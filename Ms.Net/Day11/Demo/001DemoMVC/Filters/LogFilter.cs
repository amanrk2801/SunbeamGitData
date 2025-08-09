using Microsoft.AspNetCore.Mvc.Filters;
using _001DemoMVC.Helpers;
namespace _001DemoMVC.Filters
{
    public class LogFilter : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            FileLogger.CurrentLogger.Log("Calling OnActionExecuting for method " + context.HttpContext.Request.Path);
        }
        public override void OnActionExecuted(ActionExecutedContext context)
        {
            FileLogger.CurrentLogger.Log("Calling OnActionExecuted for method " + context.HttpContext.Request.Path);
        }
    }


    //public class LogFilter :Attribute, IActionFilter
    //{
    //    public void OnActionExecuted(ActionExecutedContext context)
    //    {
    //        throw new NotImplementedException();
    //    }

    //    public void OnActionExecuting(ActionExecutingContext context)
    //    {
    //        throw new NotImplementedException();
    //    }
    //}
}
