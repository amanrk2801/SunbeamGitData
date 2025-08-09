using System.Collections;
using System.Diagnostics;
using System.Linq.Expressions;

namespace _19Demo_C_Features
{
    //delegate bool MyDelegate(int i); 
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Partial Classes
            //Maths obj = new Maths();
            //Console.WriteLine(obj.Add(10, 20));
            //Console.WriteLine(obj.Sub(10, 20));
            #endregion

            #region Implicit Type
            //var v = 100;  //as good as int v = 100;
            //v = "abcd";

            //var v = new Emp();//as good as Emp v = new Emp();

            //var v;//ERR HERE

            //Console.WriteLine(v.GetType());

            #endregion

            #region Use Properties

            //Emp emp = new Emp();
            //emp.No = 100;
            //emp.Name = "Drishtyadyumnya";

            //var emp = new Emp();
            //emp.No = 100;
            //emp.Name = "Drishtyadyumnya";
            //Console.WriteLine(emp.ToString());
            #endregion

            #region Object Initializer

            //var emp = new Emp() { No = 100, Name = "Manoj" };
            //Console.WriteLine(emp.ToString());

            #endregion

            #region Anonymous Type

            //var v = new { No = 100, Name = "Manoj" };
            ////v.Name = "abcd"; //Read Only
            //Console.WriteLine(v.GetType());
            //Console.WriteLine(v.Name);

            //Same Class Object
            //var v1 = new { No = 100, Name = "Manoj" };

            //Same Class Object
            //var v1 = new { No = "One", Name = 1234 };

            //Same Class Object
            //var v1 = new { Name = "Manoj",  No = 100  };
            //Console.WriteLine(v1.GetType());
            //Console.WriteLine(v1.Name);

            //AnonymousType0<int, string> obj = 
            //    new AnonymousType0<int, string>();

            //AnonymousType0<string, int> obj1 =
            //    new AnonymousType0<string, int>();


            #endregion

            #region Anonymous Type Collection
            //var arr = new[] 
            //{
            //  new { No = 1, Name = "Kailash1"},
            //  new { No = 2, Name = "Kailash2"},
            //  new { No = 3, Name = "Kailash3"},
            //  new { No = 4, Name = "Kailash4"},
            //};

            //foreach (var item in arr)
            //{
            //    Console.WriteLine(item.Name);
            //}


            ////object v = new { No = 1, Name = "cd" };
            ////var c = (No Idea)v;
            ////U can't get the data back from v - object
            ////data is lost
            #endregion

            #region Extension Method
            //string str = "a@b.com";

            ////MyHelper myHelper = new MyHelper();

            ////bool isitValid=
            ////    myHelper.CheckForValidEmailAddress(str);

            ////bool isitValid =
            ////   MyHelper.CheckForValidEmailAddress(str,100);

            //bool isitValid =
            // str.CheckForValidEmailAddress<string>(100);

            //int[] arr = new int[] { 10, 20, 30 };
            //Console.WriteLine(isitValid);

            //var v = new { No = 1, Name = "abc" };

            //bool isitValid1 = 
            //    v.CheckForValidEmailAddress(88);
            //Console.WriteLine(isitValid1);
            #endregion

            #region Perf Tests Lambada Expression / Tree: 
            //Via Normal call, Via Delegate, Via Anonymous
            //Via Lambada Expression
            //Via FUNC with Lambada Expression + Tree

            //OPTION 2 
            //MyDelegate pointer = new MyDelegate(Check);

            //OPTION 3 (Anonymous Method Call)
            //MyDelegate pointer = delegate (int i)
            //                    {
            //                        return (i > 10);
            //                    };

            //OPTION 4 (Anonymous Method Call using FUNC)
            //Func<int,bool> pointer = delegate (int i)
            //                    {
            //                        return (i > 10);
            //                    };

            //OPTION 5 (Lambda Method Call using FUNC)
            //Func<int, bool> pointer = (i)=>
            //                            {
            //                                return (i > 10);
            //                            };

            //OPTION 6 (Expression Tree)

            ////1. Create a Tree
            //Expression<Func<int, bool>> tree = (i) => (i > 10);

            ////2. Compile a Tree
            //Func<int, bool> pointer = tree.Compile();

            //Stopwatch sw = new Stopwatch();
            //sw.Start();


            //OPTION 1: Normal Call
            //bool result = Check(20);

            //OPTION 2: MyDelegate
            //bool result = pointer(20);


            //OPTION 3: Anonymous Method using MyDelegate
            //bool result = pointer(20);

            //OPTION 4: Anonymous Method using FUNC
            //bool result = pointer(20);

            //OPTION 5: Lambada Method using FUNC
            //bool result = pointer(20);
            //440 Ellapsed time is taken for below stages
            //Internally Steps taken are:
            //1: Create Expression Tree :
            //      - Represent Each Statement in the form of object
            //      - Generally object are of type:BinaryStatement
            //      - OR ConditionalStatement etc etc
            //      - All Objects representing the statements are put up
            //      - in BINARY TREE Format a.k.a. Expression Tree 

            //2: Compile the expression Tree in Machine Code
            //3: Execute the Machine Code / Tree / Optimized Code

            //OPTION 6: Call/ Execute already Compiled Expression Tree 
            //bool result = pointer(20);
            //sw.Stop();

            //Console.WriteLine("Result is " + result);
            //Console.WriteLine("Time taken = {0}", sw.ElapsedTicks);

            #endregion

            #region LINQ
            #region Sample Emp Collection
            var emps = new List<Emp>()
            {
                new Emp(){  No = 1, Name = "Kishor", Address = "Vashim" },
                new Emp(){  No = 2, Name = "Abhimanyu", Address = "Bhopal" },
                new Emp(){  No = 3, Name = "Rushikesh", Address = "Mumbai" },
                new Emp(){  No = 4, Name = "Omkar", Address = "Kolhapur" },
                new Emp(){  No = 5, Name = "Prateek", Address = "Chennai" },
                new Emp(){  No = 6, Name = "Rahul", Address = "Panji" },
                new Emp(){  No = 7, Name = "Prashant", Address = "Karad" }
            };
            #endregion

            #region For Each Based Collection Filtering
            //Console.WriteLine("Enter City Character to Search Emps With: ");
            //string cityFilter = Console.ReadLine();

            //var result = new List<Emp>();

            //foreach (var item in emps)
            //{
            //    if (item.Address.ToLower().Contains(cityFilter.ToLower()))
            //    {
            //        result.Add(item);
            //    }
            //}

            //Console.WriteLine("----------Filtered Data is-------------");
            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.ToString());
            //}
            #endregion

            #region Simple LINQ

            //Console.WriteLine("Enter City Character to Search Emps With: ");
            //string cityFilter = Console.ReadLine();

            //var result =
            //    (from emp in emps
            //     where emp.Address.ToLower().Contains(cityFilter.ToLower())
            //     select emp);

            //Console.WriteLine("----------Filtered Data is-------------");
            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.ToString());
            //}

            #endregion

            #region Simple LINQ : Differed Execution

            //Console.WriteLine("Enter City Character to Search Emps With: ");
            //string cityFilter = Console.ReadLine();

            ////Check for "M" as filter
            //var result =
            //    (from emp in emps
            //     where emp.Address.ToLower().Contains(cityFilter.ToLower())
            //     select emp);

            ////Check for "M" as filter
            //var result =
            //   (from emp in emps
            //    where emp.Address.ToLower().Contains(cityFilter.ToLower())
            //    select emp).ToList();


            //emps.Add(new Emp() { No = 8, Name = "Manoj", Address = "Manglore" });

            //Console.WriteLine("----------Filtered Data is-------------");
            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.ToString());
            //}

            #endregion

            #region Simple LINQ : Select only Name from collection of Emps

            //Console.WriteLine("Enter City Character to Search Emps With: ");
            //string cityFilter = Console.ReadLine();

            //var names =
            //    (from emp in emps
            //     where emp.Address.ToLower().Contains(cityFilter.ToLower())
            //     select emp.Name);

            //Console.WriteLine("----------Filtered Names Data is-------------");
            //foreach (var name in names)
            //{
            //    Console.WriteLine(name);
            //}

            #endregion

            #region Simple LINQ : Select, Where is an extension method

            //Console.WriteLine("Enter City Character to Search Emps With: ");
            //string cityFilter = Console.ReadLine();

            //var result =
            //    (from emp in emps
            //     where emp.Address.ToLower().Contains(cityFilter.ToLower())
            //     select new DataHolder() { ENo = emp.No, EName = emp.Name });

            //var result =
            //   (from emp in emps
            //    where emp.Address.ToLower().Contains(cityFilter.ToLower())
            //    select new { ENo = emp.No, EName = emp.Name })
            //    .Where((a)=> { return a.EName.ToLower().Contains("a"); });

            //var result1 =  emps.Where((emp) => { return emp.Address.ToLower
            //                                    ().Contains(
            //                                    cityFilter.ToLower      
            //                                    ()); })
            //                   .Select((emp) => { return new 
            //                                { ENo = emp.No, EName = emp.Name }; })
            //                   .Where((a) => { return 
            //                                a.EName.ToLower().Contains("a"); }); ;


            //Console.WriteLine("----------Filtered Data is-------------");
            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.ENo + item.EName);
            //}

            #endregion
            #endregion

            #region Dynamic Type

            //Factory factory = new Factory();
            //Console.WriteLine("Enter Some Number");

            ////int choice = Convert.ToInt32(Console.ReadLine());
            ////object obj = factory.GetMeSomeObject(choice);

            ////if (obj is Book)
            ////{
            ////    Book book = (Book)obj;
            ////    Console.WriteLine(book.Title);

            ////}


            //int choice = Convert.ToInt32(Console.ReadLine());
            //dynamic obj = factory.GetMeSomeObject(choice);

            ////Console.WriteLine(obj.Title);
            //Console.WriteLine(obj.fghdkgghkfdhgjkfdhdgkdjhgdhgfdhghkhfghfk);

            #endregion

            #region Option, Default, Named Parameters
            //Print(10, "Sachin", "Mumbai");
            //Print(20, "Sameer");
            //Print(30);
            //Print(40, Address: "Chennai");
            //Print(40, Address: "Chennai", Name : "Ravi");
            #endregion

            #region  Partial Method
            //Test test = new Test();
            //test.Name = "abc";
            #endregion

            #region Nullable Type
            //int? salary = null;
            ////Above line is same as below line 
            //Nullable<int> salary = null;


            //int? salary = 100;
            //int? salary = 0;
            //Console.WriteLine(salary.HasValue);
            #endregion

            #region Iterator
            //Week week = new Week();

            //foreach (string day in week)
            //{
            //    Console.WriteLine(day);
            //}

            //Console.WriteLine(week[1]);


            #endregion

            #region Indexer
            //MyDictionary myDictionary = new MyDictionary();

            //Emp emp = myDictionary[1];
            //Console.WriteLine(emp.No + emp.Name + emp.Address);

            //Emp emp2 = myDictionary["Mitesh"];
            //Console.WriteLine(emp2.No + emp2.Name + emp2.Address);
            #endregion



            Console.ReadLine();
        }

        public static void Print(int No, string Name="X", string Address="Pune")
        {
            Console.WriteLine("Details: No = {0}, Name = {1}, Address = {2}", No,Name,Address);
        }
       

        //public static bool Check(int i )
        //{ 
        //    return (i > 10);
        //}

        //Below code is not allowed..var is contextual
        ////public void F1(var v) 
        ////{
        ////}
    }


    public class MyDictionary
    {
        private Emp[] emps = 
            new Emp[] 
            { 
                new Emp(){ No = 11, Name = "Hitesh", Address ="Pune1" },
                new Emp(){ No = 12, Name = "Gitesh", Address ="Pune2" },
                new Emp(){ No = 13, Name = "Nitesh", Address ="Pune3" },
                new Emp(){ No = 14, Name = "Mitesh", Address ="Pune4" },
            };

        public Emp this[int i]
        {
            get { return emps[i]; }
        }

        public Emp this[string name]
        {
            get 
            {
                Emp emp = (from e in emps
                           where e.Name == name
                           select e).First();
                return emp;
            }
        }

    }

    public class Week : IEnumerable
    {
        private string []days = new string[]
                                {
                                    "Monday", 
                                    "Tuesday", 
                                    "Wednesday"
                                };


        public string this[int i]
        {
            get { return days[i]; }
        }



        public IEnumerator GetEnumerator()
        {
            for (int i = 0; i < days.Length; i++)
            {
               yield return days[i];
            }
        }
    }

    public class DataHolder
    {
        public int ENo { get; set; }
        public string EName { get; set; }

    }
    public static class MyHelper
    {
        //public static bool CheckForValidEmailAddress<T>(this string s, int i)
        //{
        //    //return s.Contains("@");
        //    return true;
        //}
        public static bool CheckForValidEmailAddress<T>(this T s, int i)
        {
            //return s.Contains("@");
            return true;
        }
    }

    //public class MyString: String
    //{

    //}

    public class AnonymousType0<No ,Name>
    { 
        //logic .. properties ...
    }
    public class AnonymousType1<Name, No>
    {
        //logic .. properties ...
    }

    #region POCO
    public class Emp
    {
        #region Auto Property
        public int No { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        #endregion

        #region Old Way of writing property
        //private int _No;
        //private string _Name;

        //public string Name
        //{
        //    get { return _Name; }
        //    set { _Name = value; }
        //}

        //public int No
        //{
        //    get { return _No; }
        //    set { _No = value; }
        //}
        #endregion

        public override string ToString()
        {
            return string.Format("No = {0}, Name = {1}, Addres= {2}", No, Name,Address);
        }
    }

    public class Book
    {
        public int ISBN { get; set; }
        public string Title { get; set; }
    }

    public class Factory
    {
        public object GetMeSomeObject(int choice)
        {
            if (choice == 1) {
                return new Emp() { Name = "Jayesh" };
            }
            else
            {
                return new Book() { Title = "Let us C!" };
            }
        }
    }
    
    #endregion
}
