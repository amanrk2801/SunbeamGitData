using _001DemoMVC.Models;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;


namespace _001DemoMVC.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [EnableCors(policyName: "Policy-No-1")]
    public class EmpsController : ControllerBase
    {
        EFDBContext dbContext = new EFDBContext();

        [HttpGet]
        public IEnumerable<Emp> Get()
        {
            //return dbContext.Emps.ToList();
            return new List<Emp>() {
                new Emp{ No=14, Name="Parajay", Address="Chennai" },
                new Emp{ No=16, Name="Karan", Address="Delhi" },
                new Emp{ No=17, Name="Mahesh", Address="Pune" },
                new Emp{ No=18, Name="Nilesh", Address="Pune" },
                new Emp{ No=19, Name="Devendra", Address="Nagpur" }
            };
        }

        [HttpGet("{id}")]
        public Emp Get(int id)
        {
            return dbContext.Emps.Find(id);
        }

       
        [HttpPost]
        public void Post([FromBody] Emp value)
        {
            dbContext.Emps.Add(value);
            dbContext.SaveChanges();
        }

        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Emp value)
        {
            Emp emp =  dbContext.Emps.Find(id);
            emp.Name = value.Name;
            emp.Address = value.Address;
            dbContext.SaveChanges();
        }

        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Emp emp = dbContext.Emps.Find(id);
            dbContext.Emps.Remove(emp);
            dbContext.SaveChanges();
        }
    }
}
