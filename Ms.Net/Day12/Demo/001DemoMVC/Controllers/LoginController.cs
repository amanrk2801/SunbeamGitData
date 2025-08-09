using _001DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;

namespace _001DemoMVC.Controllers
{
    public class LoginController : Controller
    {
        public IActionResult SignIn()
        {
            return View();
        }

        [HttpPost]
        public IActionResult SignIn(SBUser user)
        {
            //Check with DB
            if (user.UserName == "mahesh" && user.Password == "mahesh@123")
            {
                this.HttpContext.Session.SetString("username", user.UserName);
                return Redirect("/Test/Index");
            }
            else
            {
                ViewBag.Message = "Invalid Credentials!";
                return View();
            }
          
        }

        public IActionResult LogOut()
        {
            this.HttpContext.Session.Remove("username");
            return Redirect("/Test/Index");
        }
    }
}
