using System.Runtime.Serialization.Formatters.Binary;

namespace _11DemoFileIO
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Simple Text Write
            //string path = "D:\\KaradDotNetDemos\\Data\\Sample.txt";
            //FileStream fs = null;

            //if (File.Exists(path))
            //{
            //    fs = new FileStream(path, FileMode.Append, FileAccess.Write);
            //}
            //else
            //{
            //    fs = new FileStream(path, FileMode.Create, FileAccess.Write);
            //}

            //StreamWriter pen = new StreamWriter(fs);

            //Console.WriteLine("Enter something");

            //string someData  = Console.ReadLine();

            //pen.WriteLine(someData);

            //pen.Close();
            //fs.Close();
            #endregion

            #region Simple Text Read

            //string path = "D:\\KaradDotNetDemos\\Data\\Sample.txt";
            //FileStream fs = null;

            //if (File.Exists(path))
            //{
            //    fs = new FileStream(path, FileMode.Open, FileAccess.Read);
            //    StreamReader reader = new  StreamReader(fs);
            //    string someData = reader.ReadToEnd();
            //    Console.WriteLine(someData);

            //    reader.Close();
            //    fs.Close();
            //}
            //else
            //{
            //    Console.WriteLine("File not found!");
            //}

            //Console.ReadLine();
            #endregion

            #region Simple Object Write

            //            string path = "D:\\KaradDotNetDemos\\Data\\SampleObjectData.txt";
            //            FileStream fs = null;

            //            if (File.Exists(path))
            //            {
            //                fs = new FileStream(path, FileMode.Append, FileAccess.Write);
            //            }
            //            else
            //            {
            //                fs = new FileStream(path, FileMode.Create, FileAccess.Write);
            //            }

            //            #pragma warning disable SYSLIB0011 // Type or member is obsolete
            //            BinaryFormatter pen = new BinaryFormatter();
            //            #pragma warning restore SYSLIB0011 // Type or member is obsolete

            //            Emp emp = new Emp();

            //            Console.WriteLine("Enter No");
            //            emp.No = Convert.ToInt32(Console.ReadLine());

            //            Console.WriteLine("Enter Name");
            //            emp.Name = Console.ReadLine();

            //            Console.WriteLine("Enter Address");
            //            emp.Address = Console.ReadLine();

            //#pragma warning disable SYSLIB0011
            //            pen.Serialize(fs, emp);
            //#pragma warning disable SYSLIB0011
            //            pen = null;
            //            fs.Close();
            #endregion

            #region Simple Object Read

//            string path = "D:\\KaradDotNetDemos\\Data\\SampleObjectData.txt";
//            FileStream fs = null;

//            if (File.Exists(path))
//            {
//                fs = new FileStream(path, FileMode.Open, FileAccess.Read);


//#pragma warning disable SYSLIB0011 // Type or member is obsolete
//                BinaryFormatter reader = new BinaryFormatter();
//#pragma warning restore SYSLIB0011 // Type or member is obsolete

//#pragma warning disable SYSLIB0011
//             object obj=   reader.Deserialize(fs);
//#pragma warning disable SYSLIB0011

//                if(obj is Emp)
//                {
//                    Emp emp = (Emp)obj;
//                    Console.WriteLine(emp.No);
//                    Console.WriteLine(emp.Name);
//                    Console.WriteLine(emp.Address);
//                }
//                else
//                {
//                    Console.WriteLine("Unknown type of data!");
//                }

//                reader = null;
//                fs.Close();
//            }
//            else
//            {
//                Console.WriteLine("File not found");
//            }
            #endregion
        }
    }


    [Serializable]
    public class Emp
    {
        private int _No;
        private string _Name;
        private string _Address;

        [NonSerialized]
        private string _password = "mahesh@123";

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
