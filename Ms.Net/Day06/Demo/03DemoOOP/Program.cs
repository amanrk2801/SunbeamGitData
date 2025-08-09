namespace _03DemoOOP
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Editor editor = new Editor();


            Console.WriteLine("1: Spanish, 2: Hindi, 3: Marathi, 4: English");
            int choice = Convert.ToInt32(Console.ReadLine());

            SpellCheckerFactory spellCheckerFactory = new SpellCheckerFactory();
            ISpellChecker someSpellChecker =
                    spellCheckerFactory.GetSpellChecker(choice);

            Editor editor = new Editor(someSpellChecker);
            editor.SpellingCheck("abcd");
            Console.ReadLine();
        }
    }

    public class Editor
    {
        private ISpellChecker checker;
        public Editor()
        {
            checker = new EnglishSpellChecker();
        }
        public Editor(ISpellChecker someChecker)
        {
            checker = someChecker;
        }

        public void Copy()
        {
            Console.WriteLine("Copy Called");
        }

        public void SpellingCheck(string word)
        {
            checker.SpellCheck(word);
        }
    }

    public interface ISpellChecker
    {
        void SpellCheck(string word);
    }

    public class EnglishSpellChecker : ISpellChecker
    {
        public void SpellCheck(string word)
        {
            Console.WriteLine("Spelling Checked for English Language");
        }
    }

    public class SpanishSpellChecker : ISpellChecker
    {
        public void SpellCheck(string word)
        {
            Console.WriteLine("Spelling Checked for Spanish Language");
        }
    }

    public class HindiSpellChecker : ISpellChecker
    {
        public void SpellCheck(string word)
        {
            Console.WriteLine("Spelling Checked for Hindi Language");
        }
    }

    public class MarathiSpellChecker : ISpellChecker
    {
        public void SpellCheck(string word)
        {
            Console.WriteLine("Spelling Checked for Marathi Language");
        }
    }

    public class SpellCheckerFactory// Inversion Of Control = IOC
    {
        public ISpellChecker GetSpellChecker(int choice)
        {
            if (choice == 1)
            {
                return new SpanishSpellChecker();
            }
            else if (choice == 2)
            {
                return new HindiSpellChecker();
            }
            else if (choice == 3)
            {
                return new MarathiSpellChecker();
            }
            else
            {
                return new EnglishSpellChecker();
            }
        }
    }

}
