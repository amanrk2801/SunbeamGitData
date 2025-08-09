using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _19Demo_C_Features
{
    //Written by Mahesh
    public partial class Maths
    {
        public int Add  (int x, int y)
        {
            return x + y;
        }
    }

    //Written by Mahesh
    public partial class Test
    {
        partial void Validate(string value);

        private string _Name;

        public string Name
        {
            get { return _Name; }
            set 
            {
                //Validate Here
                Validate(value);
                _Name = value; 
            }
        }

    }
}
