using System.Text.Json;
using System.Xml.Serialization;

namespace _12DemoSerialization
{
    public class Program
    {
        static void Main(string[] args)
        {
            #region XML Serialization
            //Emp emp = new Emp();

            //Console.WriteLine("Enter No");
            //emp.No = Convert.ToInt32(Console.ReadLine());

            //Console.WriteLine("Enter Name");
            //emp.Name = Console.ReadLine();

            //Console.WriteLine("Enter Address");
            //emp.Address = Console.ReadLine();

            //string path = "D:\\KaradDotNetDemos\\Data\\Sample.xml";

            //FileStream fs = new FileStream(path, FileMode.Create, FileAccess.Write);

            //XmlSerializer
            //    serializer = new XmlSerializer(typeof(Emp));

            //serializer.Serialize(fs, emp);

            //fs.Close(); 
            #endregion

            #region XML Deserialization
            // string path = "D:\\KaradDotNetDemos\\Data\\Sample.xml";

            // FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read);

            // XmlSerializer
            //     serializer = new XmlSerializer(typeof(Emp));

            //object obj   =  serializer.Deserialize(fs);
            // if (obj is Emp)
            // {
            //     Emp emp = (Emp)obj;
            //     Console.WriteLine(emp.No);
            //     Console.WriteLine(emp.Name);
            //     Console.WriteLine(emp.Address);
            // }
            // fs.Close();
            #endregion

            #region JSON Serialization
            //Emp emp = new Emp();

            //Console.WriteLine("Enter No");
            //emp.No = Convert.ToInt32(Console.ReadLine());

            //Console.WriteLine("Enter Name");
            //emp.Name = Console.ReadLine();

            //Console.WriteLine("Enter Address");
            //emp.Address = Console.ReadLine();

            //string path = "D:\\KaradDotNetDemos\\Data\\Sample.json";

            //FileStream fs = new FileStream(path, FileMode.Create, FileAccess.Write);

            //JsonSerializer.Serialize<Emp>(fs, emp);
            //fs.Close();
            #endregion

            #region JSON Deserialization
            
            string path = "D:\\KaradDotNetDemos\\Data\\Sample.json";

            FileStream fs = new FileStream(path, FileMode.Open, FileAccess.Read);

            Emp emp = JsonSerializer.Deserialize<Emp>(fs);

            Console.WriteLine(emp.No);
            Console.WriteLine(emp.Name);
            Console.WriteLine(emp.Address);

            fs.Close();

            Console.ReadLine();
            #endregion
        }
    }

    public class Emp
    {
        private int _No;
        private string _Name;
        private string _Address;

        public string Address
        {
            get { return _Address; }
            set { _Address = value; }
        }

        public string Name
        {
            get { return _Name; }
            set { _Name = value; }
        }

        public int No
        {
            get { return _No; }
            set { _No = value; }
        }

    }
}
