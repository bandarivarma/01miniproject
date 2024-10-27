package in.ashokit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entities.UserAccount;
import in.ashokit.service.UserAccountService;


@Controller
public class UserAccountController {
	
	  @Autowired 
	  private UserAccountService service;
	 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user",new UserAccount());
		return "index";
		
	}
	/*@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user,Model model) {
		System.out.println(user);
		String msg = service.saveOrUpdateUserAcc(user);
		model.addAttribute("msg", msg);
		return "index";
		
	}*/
	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user,Model model) {
		System.out.println(user);
	
		String msg = service.saveOrUpdateUserAcc(user);
		model.addAttribute("msg", msg);
		model.addAttribute("user",new UserAccount());
		return "index";
		
	}
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<UserAccount> userList = service.getAllUserAccounts();
		model.addAttribute("users", userList);
		return "view-users";
	}
	@GetMapping("/edit")
	public String editUser(@RequestParam("id") Integer id, Model model) {
		UserAccount userAcc = service.getUserAcc(id);
		model.addAttribute("user",userAcc);
		return "index";
		
	}
	/*@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer uid, Model model) {
		boolean deleteUserAcc = service.deleteUserAcc(uid);
		return "redirect:/users";
	}*/
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer uid, Model model) {
		service.deleteUserAcc(uid);
		model.addAttribute("msg", "successfully deleted");
		return "forward:/users";
	}
	/*@GetMapping("/update")
	public String statusUpdate(@RequestParam("id") Integer uid,@RequestParam("status") String status) {
		boolean updateUserAccStatus = service.updateUserAccStatus(uid, status);
		return "redirect:/users";
	}*/
	@GetMapping("/update")
	public String statusUpdate(@RequestParam("id") Integer uid, @RequestParam("status") String status,Model model) {
		boolean updateUserAccStatus = service.updateUserAccStatus(uid, status);
		if("Y".equals(status)) {
			model.addAttribute("msg", "userAccount activated");
		}else {
			model.addAttribute("msg", "userAccount DeActivated");
		}
		
		return "forward:/users";
	}
}
