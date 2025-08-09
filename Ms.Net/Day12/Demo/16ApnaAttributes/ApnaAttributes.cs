namespace _16ApnaAttributes
{
	//Imagine below Table and Column Classes are just like
	//the way microsoft has written Serializable class!

	//public class SerializableAttribute : Attribute {}

    public class Table : Attribute
    {
		private string _TableName;

		public string TableName
		{
			get { return _TableName; }
			set { _TableName = value; }
		}

	}

	public class Column : Attribute
	{
		private string _ColumnName;
		private string _ColumnType;

		public string ColumnType
		{
			get { return _ColumnType; }
			set { _ColumnType = value; }
		}

		public string ColumnName
		{
			get { return _ColumnName; }
			set { _ColumnName = value; }
		}

	}

}
