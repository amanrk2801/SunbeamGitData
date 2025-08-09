using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace WebApplication1.Models
{
    public class Emp
    {
        [DisplayName("ENo")]
        public int No { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
    }
}
