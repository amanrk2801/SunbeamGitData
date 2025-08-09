using _001DemoMVC.Models;
using Microsoft.EntityFrameworkCore;

namespace _001DemoMVC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            //We will now add "EFDBContext" in the DI Container
            //So we can just expect EFDBContext in constructor 
            //of Controller and we can get it directly
            builder.Services.AddDbContext<EFDBContext>((context)=> {
                context.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EFDB;Integrated Security=True;");
               });


            builder.Services.AddControllersWithViews();
            builder.Services.AddSession();

            builder.Services.AddCors((options) => 
            {
                options.AddPolicy("Policy-No-1", (builder) => {
                    builder.WithOrigins("*").WithMethods("*").WithHeaders("*");
                });

                options.AddPolicy("Policy-No-2", (builder) => {
                    builder.WithOrigins("sunbeaminfo.com").WithMethods("GET").WithHeaders("*");
                });

                options.AddPolicy("Policy-No-3", (builder) => {
                    builder.WithOrigins("abc.com, xyz.com").WithMethods("GET").WithHeaders("content-type");
                });

                options.AddPolicy("Policy-No-4", (builder) => {
                    builder.WithOrigins("pqr.com").WithMethods("PUT").WithHeaders("*");
                });

            });

            var app = builder.Build();


           
            app.UseSession();

            app.UseStaticFiles();

            app.UseRouting();
            app.UseCors();
            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Test}/{action=Index}/{id?}");

            app.Run();
        }
    }
}
