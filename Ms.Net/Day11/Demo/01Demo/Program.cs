using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01Demo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Person person = new Person();
            //person.SetName("abc");
            //string nm = person.GetName();
            //Console.WriteLine(nm);

            Person person = new Person();
            person.Name = "abc"; //this line will call Set
            //string nm = person.Name;//this line will call GET
            //Console.WriteLine(nm);

            person.Address = "Kolkata";

            string details = person.GetDetails();

            Console.WriteLine(details);

            Console.ReadLine();
        }
    }

    public class Person
    {
        #region Private Members
        private int _No;
        private string _Name;
        private string _Address;
        #endregion

        #region Properties OR Getter / Setters

        public string Address
        {
            get { return _Address; }
            set { _Address = value; }
        }

        public string Name
        {
            get { return "Mr / Mrs  " + _Name; }
            set { _Name = value; }
        }

        public int No
        {
            get { return _No; }
            set { _No = value; }
        }

        #endregion

        #region Writing Getter / Setter using .NET Property
        //private string _Name;

        //public string Name
        //{
        //    get 
        //    {
        //        // manipulate data
        //        //present it well using getter
        //        return "Mr / Mrs " + _Name; 
        //    }
        //    set 
        //    {
        //        //validate here the value
        //        //if correct then
        //        _Name = value; 
        //    }
        //}
        #endregion

        #region Old way of writing getter setter like C++ / Java



        //private string _Name;

        //public void SetName(string value)
        //{
        //    //validate here the value
        //    //if correct then
        //    _Name = value;
        //}

        //public string GetName()
        //{
        //    //manipulate data 
        //    //present it well using getter
        //    return  "Mr/ Mrs " + _Name;
        //}

        #endregion


        /// <summary>
        /// This method concats Name and Address 
        /// </summary>
        /// <returns>Name, Address Concated</returns>
        public string GetDetails()
        {
            return Name + Address;
        }

    }
}
