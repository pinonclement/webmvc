package com.websystique.springsecurity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.model.UserProfile;
import com.websystique.springsecurity.model.Video;
import com.websystique.springsecurity.service.UserProfileService;
import com.websystique.springsecurity.service.UserService;
import com.websystique.springsecurity.service.VideoService;

@Controller
public class HelloWorldController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController.class);

	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	VideoService videoService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "hello";
	}
	
	@RequestMapping(value="/enregistrer", method=RequestMethod.GET)
	public String enregistrerPag(ModelMap model){
		User user = new User();
		model.addAttribute("user", user);
		return "inscription";
	}
	
	@RequestMapping(value="/enregistrer", method=RequestMethod.POST)
	public String inscription(@Valid User user,
			BindingResult result, ModelMap model){
		
		
		 Date actuelle = new Date();
    	 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	 String dat = dateFormat.format(actuelle);
         user.setDateinscription(dat);
         userService.save(user);
		return "hello";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public String hello2Page(){
		return "hello2";
	}
	
	@RequestMapping(value="/ajoutvid", method=RequestMethod.GET)
	public String ajoutvidPage(ModelMap model){
		Video video = new Video();
		model.addAttribute("video", video);
		return "ajoutvid";
	}
	
	@RequestMapping(value="/connexion", method=RequestMethod.GET)
	public String connexionPage(ModelMap model){
		
		return "connexion";
	}
	@RequestMapping(value="/erreurmdp", method=RequestMethod.GET)
	public String erreurmdpPage(ModelMap model){
		
		return "erreurmdp";
	}
	
	@RequestMapping(value="/erreursrt", method=RequestMethod.GET)
	public String erreursrtPage(ModelMap model){
		
		return "erreursrt";
	}
	@RequestMapping(value="/modifmdp", method=RequestMethod.GET)
	public String modifmdpPage(ModelMap model){
		
		return "modifmdp";
	}
	@RequestMapping(value="/mdpoublie", method=RequestMethod.GET)
	public String mdpiubliePage(ModelMap model){
		
		return "mdpoublie";
	}
	@RequestMapping(value="/usernotexist", method=RequestMethod.GET)
	public String usernotexistPage(ModelMap model){
		
		return "usernotexist";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	
	
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	
	@RequestMapping(value="/recherche", method=RequestMethod.GET)
	public String recherchePage(ModelMap model, HttpServletResponse response){
		return "rechercher";
	}
	
	@RequestMapping(value="/recherche", method=RequestMethod.POST)
	public String recherche(@RequestParam("filtre") String filtre, @RequestParam("name") String result, ModelMap model, HttpServletRequest request){
		List<Video> test;
		if(filtre.equals("Duree")){
			test=videoService.listVideoByDurée(result);
			request.getSession().setAttribute("listevideo",test);		
			return "redirect:/recherche";
		}
		if(filtre.equals("Date d'ajout")){
			test=videoService.listVideoByDate(result);
			request.getSession().setAttribute("listevideo",test);
			return "redirect:/recherche";
		}
		
		if(filtre.equals("Sous-titre : Non")){
			test=videoService.getSoustitre();
			request.getSession().setAttribute("listevideo",test);
			return "redirect:/recherche";
		}
		
		return "hello2";
		
		
	}
	
	@RequestMapping(value="/pagevideo",method=RequestMethod.GET)
	public String videoPage(ModelMap map){
		return "pagevideo";
	}
	
	@RequestMapping(value="recherche/gopage",method=RequestMethod.POST)
	public String goPage(@ModelAttribute("secretValue") int id, HttpServletRequest request){
		System.out.println(id);
		Video test=videoService.getVideoById(id);
		request.getSession().setAttribute("video", test);
		return "pagevideo";
	}
	
	@RequestMapping(value="/uploadsrt",method=RequestMethod.GET)
	public String uploadPage(){
		return "uploadsrt";
	}
	
	@RequestMapping(value="/uploadsrt",method=RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				final File f = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
				File g=f.getParentFile().getParentFile();
				String folder = g.getAbsolutePath();	
				folder+="\\static\\srt";
				System.out.println(folder);
				File dir = new File(folder);
				if (!dir.exists())
					dir.mkdirs();
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="+ serverFile.getAbsolutePath());
				System.out.println("ici");
				return "hello2";
			} catch (Exception e) {
				return "hello";
			}	
			
	}
		return "hello2";

	
	
}
	
	
@RequestMapping(value="/ajoutvid",method=RequestMethod.POST)
public @ResponseBody
String AjoutVidHandler(@RequestParam("name") String name,
		@RequestParam("file") MultipartFile file,@Valid Video video) {

	if (!file.isEmpty()) {
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			final File f = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
			File g=f.getParentFile().getParentFile();
			String folder = g.getAbsolutePath();	
			folder+="\\static\\video";
			System.out.println(folder);
			File dir = new File(folder);
			if (!dir.exists())
				dir.mkdirs();
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			videoService.addVideo(video);

			logger.info("Server File Location="+ serverFile.getAbsolutePath());
			System.out.println("ici");
			return "hello2";
		} catch (Exception e) {
			return "hello";
		}	
		
}
	return "hello2";
	
	



}
}