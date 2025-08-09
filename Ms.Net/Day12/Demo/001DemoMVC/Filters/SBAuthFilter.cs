using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace _001DemoMVC.Filters
{
    public class SBAuthFilter: ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            string userName = context.HttpContext.Session.GetString("username");
            if(userName == null )
            {
                context.Result = new RedirectResult("/Login/SignIn");
            }
            else
            {
                if(userName != "mahesh")//Check with DB - username
                {
                    context.Result = new ContentResult() { Content = "Invalid Login / Role / Or You do not have permission!" };
                }
                
            }
        }
    }
}
