# C# Cheat Sheet



## Basics

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


## Testing

    [Theory]
    [InlineData(-1)]
    [InlineData(0)]
    [InlineData(1)]
    public void IsPrime_ValuesLessThan2_ReturnFalse(int value)
    {
        var result = _primeService.IsPrime(value);
        
        Assert.False(result, $"{value} should not be prime");
    }


## More Resources

- Great: https://www.toptal.com/c-sharp/top-10-mistakes-that-c-sharp-programmers-make
