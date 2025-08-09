#region Using Reflection to Call Methods

using System.Reflection;

namespace _15DemoReflection
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string assemblyPath = "D:\\KaradDotNetDemos\\Demo\\MathLib\\bin\\Debug\\net8.0\\MathLib.dll";

            Assembly assembly = Assembly.LoadFrom(assemblyPath);
            Type[] allTypes = assembly.GetTypes();

            foreach (Type type in allTypes)
            {

                Console.WriteLine(type.FullName);
                Console.WriteLine("--------------------------");

                Console.WriteLine("creating object of {0} .... " , type.FullName);

                object dynamicallyCreatedObject =
                    assembly.CreateInstance(type.FullName);

                MethodInfo[] methods = type.GetMethods();

                foreach (MethodInfo method in methods)
                {
                    Console.WriteLine(
                        "- Calling {0} ", method.Name);

                    ParameterInfo[] parameters =
                         method.GetParameters();

                    object[] inputValues =
                        new object[parameters.Length]; 

                    for(int i = 0;i< parameters.Length; i++)
                    {
                        ParameterInfo parameter = parameters[i];

                        Console.WriteLine(
                            "Please provide value of {0}  type for {1} ", parameter.ParameterType, parameter.Name);

                        
                        inputValues[i] =Convert.ChangeType(
                                        Console.ReadLine(),
                                        parameter.ParameterType);

                        Console.WriteLine();
                    }
                    Console.WriteLine();

                     object result =  
                        type.InvokeMember(method.Name,
                        BindingFlags.Public |
                        BindingFlags.Instance |
                        BindingFlags.InvokeMethod,
                        null,
                        dynamicallyCreatedObject,
                        inputValues);

                    Console.WriteLine("Result of {0} is {1}",
                                        method.Name, result);

                }
            }

            Console.ReadLine();
        }
    }
}


#endregion

#region Basic Reflection
//using System.Reflection;

//namespace _15DemoReflection
//{
//    internal class Program
//    {
//        static void Main(string[] args)
//        {
//            string assemblyPath = "D:\\KaradDotNetDemos\\Demo\\MathLib\\bin\\Debug\\net8.0\\MathLib.dll";

//            //string assemblyPath = "D:\\KaradDotNetDemos\\Demo\\02DemoOOP\\bin\\Debug\\net8.0\\02DemoOOP.dll";

//            Assembly assembly = Assembly.LoadFrom(assemblyPath);
//            Type[] allTypes = assembly.GetTypes();

//            foreach (Type type in allTypes) {

//                Console.WriteLine(type.FullName);
//                Console.WriteLine("--------------------------");

//                IEnumerable<Attribute> allAttributesOnType =
//                    type.GetCustomAttributes();

//                bool isSerializable = false;

//                foreach (Attribute attribute in             
//                                        allAttributesOnType)
//                {
//                    if (attribute is SerializableAttribute)
//                    {
//                        isSerializable = true;
//                        break;
//                    }
//                }

//                if (isSerializable)
//                {
//                    Console.WriteLine("{0} is marked as Serializable", type.FullName);
//                }
//                else
//                {
//                    Console.WriteLine("{0} is 'NOT' marked as Serializable", type.FullName);
//                }

//                Console.WriteLine("--------------------------");

//                MethodInfo[] methods = type.GetMethods();

//                foreach (MethodInfo method in methods)
//                {
//                    Console.Write(" --- {0}  {1} (", method.ReturnType,method.Name);

//                    ParameterInfo[] parameters =
//                         method.GetParameters();

//                    foreach (ParameterInfo parameter in parameters)
//                    {
//                        Console.Write("{0}  {1} ", parameter.ParameterType, parameter.Name);
//                    }
//                    Console.Write(" ) ");
//                    Console.WriteLine();
//                }
//            }

//            Console.ReadLine();
//        }
//    }
//} 
#endregion
