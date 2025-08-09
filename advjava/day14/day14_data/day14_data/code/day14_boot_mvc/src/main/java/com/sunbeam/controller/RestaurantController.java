package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunbeam.entities.Restaurant;
import com.sunbeam.service.RestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final HelloWorldController helloWorldController;
 //depcy  - service layer interface
	@Autowired 
	private RestaurantService restaurantService;
	public RestaurantController(HelloWorldController helloWorldController) {
		System.out.println("in ctor of "+getClass());
		this.helloWorldController = helloWorldController;
	}
	/*
	 * Desc - add new method for rendering list of restaurants
	 * URL - http://host:port/ctx/restaurants/list
	 * Method - GET
	 * Payload - none
	 * Resp - render dyn resp (list)
	 */
	@GetMapping("/list")
	public String listRestaurants(Model modelAttrMap) {
		System.out.println("in list "+modelAttrMap);//{}
		//add list of restaurant(from service layer) in model map
		modelAttrMap.addAttribute
		("restaurant_list", restaurantService.getAvailableRestaurants());
		//ret LVN 
		return "restaurants/list";
		//AVN - /WEB-INF/views/restaurants/list.jsp
	}
	/*
	 * 4. Description –Soft Delete Specific restaurant
After clicking on the "Delete" link
URL - http://host:post/ctx_path/restaurants/delete?id=...
Method - GET
Payload - request param - restaurantId
Action - soft delete restaurant details 

	 */
	@GetMapping("/delete")
	public String deleteRestaurantDetails(
			@RequestParam Long id,RedirectAttributes flashMap) {
		System.out.println("in delete "+id);
		//invoke service layer method
		flashMap.addFlashAttribute("message",
				restaurantService.deleteDetails(id));
		return "redirect:/restaurants/list";
				//"restaurants/list";		//AVN - /WEB-INF/views/restaurants/list.jsp
	}
	/*
	 * SC - response.sendRedirect
	 * (response.encodeRedirectURL("/restaurants/list"));
	 * Send Resp - SC 302 , Header - Location : /restaurants/list
	 * body - empty
	 * web browser send new request
	 * http://host:port/ctx_path/restaurants/list
	 *  - renders updated view !
	 */
	/*
	 * After clicking on the "Add new restaurant" button/link
URL - http://host:post/ctx_path/restaurants/add_form
Method - GET
Payload - none
Action - Render Add Restaurant form (form fields - restaurant's basic details)
Resp - Render add restaurant form

	 */
	@GetMapping("/add_form")
	public String showAddRestaurantForm(Model map)
	{
		System.out.println("in show add form "+map);//{}
		//add model - Restaurant to model map
		map.addAttribute("new_restaurant", new Restaurant());
		//forward request -> view layer -> LVN
		return "restaurants/add_restaurant_form";
	}
	
	/*
	 * After submitting the form 
URL - http://host:post/ctx_path/restaurants/add_form
Method - POST
Payload - form data (restaurant details)
Action - save new restaurant details in DB
Resp - redirect the client to list page (in the request)

	 */
	@PostMapping("/add_form")
	public String processAddRestaurantForm(@ModelAttribute
			(name="new_restaurant") Restaurant transientRestaurant
			,RedirectAttributes flashMap) {
		System.out.println("in process add "
			+transientRestaurant+" "+flashMap);
		//invoke service layer method n save message under flash map
		flashMap.addFlashAttribute("message",restaurantService
				.addNewRestaurant(transientRestaurant));
		//redirect - to refresh view
		return "redirect:/restaurants/list";
		
	}
	/*
	 * After clicking on the "Update" link
URL - http://host:post/ctx_path/restaurants/update?id=...
Method - GET
Payload - request param - restaurantId
Action - Render Update form (pre populated)
restaurant id - readonly
Resp - Render restaurant details update form to the client

	 */
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam Long id,
			Model map) {
		System.out.println("in show update form "+id+" "+map);
		//invoke service layer method - to lift restaurant details from DB
		//add this in model map
		map.addAttribute("restaurant",
				restaurantService.getRestaurantDetails(id));
		//forward
		return "restaurants/update_form";
	}
	
	/*
	 * After submitting the update form 
URL - http://host:post/ctx_path/restaurants/update_form
Method - POST
Payload - form data (update restaurant details)
Action - update   restaurant details in DB
Resp - redirect the client to list page (in the request)

	 */
	@PostMapping("/update")
	public String processUpdateRestaurantForm(@RequestParam Long id,
			@ModelAttribute
			(name="restaurant") Restaurant restaurant
			,RedirectAttributes flashMap) {
		System.out.println("in process update "
			+restaurant+" "+flashMap);
		//invoke service layer method n save message under flash map
		flashMap.addFlashAttribute("message",restaurantService
				.updateRestaurant(id,restaurant));
		//redirect - to refresh view
		return "redirect:/restaurants/list";
		
	}
	
	
	
}
