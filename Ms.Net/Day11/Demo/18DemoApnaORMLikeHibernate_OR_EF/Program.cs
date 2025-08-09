using _16ApnaAttributes;
using System.Reflection;

namespace _18DemoApnaORMLikeHibernate_OR_EF
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string assemblyPath = "D:\\KaradDotNetDemos\\Demo\\17DemoPOCOLib\\bin\\Debug\\net8.0\\17DemoPOCOLib.dll";

            //Use reflection to find metadata here...

            Assembly assembly = Assembly.LoadFrom(assemblyPath);
            Type[] types = assembly.GetTypes();

            string query = "";

            foreach (Type type in types)
            {
                IEnumerable<Attribute> typeLevelAttributes =
                                 type.GetCustomAttributes();
            

                foreach (Attribute attribute in typeLevelAttributes)
                {
                    if (attribute is Table)
                    {
                        Table table = (Table)attribute;
                        query = query + " create table " +   
                            table.TableName  + " ( ";
                        break;
                    }
                }

                PropertyInfo[] properties =
                    type.GetProperties();

                foreach (PropertyInfo property in properties)
                {
                    IEnumerable<Attribute> propertyLevelAttributes
                            = property.GetCustomAttributes();

                    foreach(Attribute attribute in propertyLevelAttributes)
                    {
                        if (attribute is Column) 
                        {
                         Column column = (Column)attribute;
                         query = query 
                                   + column.ColumnName + " "
                                   + column.ColumnType + ",";
                        break;
                        }
                    }
                }

               query =  query.TrimEnd(',');
                query = query + " );";
            }

            Console.WriteLine(query);
            Console.WriteLine();
           
            FileStream fileStream = new FileStream("D:\\KaradDotNetDemos\\Data\\Queries.sql", FileMode.OpenOrCreate, FileAccess.Write);

            StreamWriter writer = new StreamWriter(fileStream);
            writer.WriteLine(query);
            writer.Close();
            fileStream.Close();

            Console.WriteLine("Query Written in To SQL File");
            Console.ReadLine();

        }
    }
}
