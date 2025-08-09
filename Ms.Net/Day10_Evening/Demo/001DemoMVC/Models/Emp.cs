using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace _001DemoMVC.Models
{
    [Table("Employee")]
    public class Emp
    {
        [Column("No")]
        [Key]
        public int No { get; set; }

        [Column("Name")]
        [StringLength(50)]
        public string Name { get; set; }

        [Column("Address")]
        [StringLength(50)]
        public string Address { get; set; }
    }
}
