# C# Cheat Sheet


    public class Person
    {
        private string name;
        
        public string Name
        {
            get
            {
                return string.IsNullOrWhiteSpace(name) ? string.Empty : name;
            }
            set { name = value; }
        }
        
        // Same as `public string Age { get; private set; }`
        public string Age { get; }
        
    }


## More Resources

- Great: https://www.toptal.com/c-sharp/top-10-mistakes-that-c-sharp-programmers-make
