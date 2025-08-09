using Microsoft.AspNetCore.Mvc;
using _001DemoMVC.Filters;
namespace _001DemoMVC.Controllers
{
    [LogFilter]
    public class BaseController : Controller
    {
    }
}
