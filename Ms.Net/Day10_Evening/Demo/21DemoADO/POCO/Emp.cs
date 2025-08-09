using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21DemoADO.POCO
{
    public class Emp
    {
        public int No { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }

        public override string ToString()
        {
            return string.Format("{0} | {1} | {2}", No, Name, Address);
        }
    }
}
