import java.util.ArrayList;
public class Pig {

    /*
    * Create a method "pigLatin" that takes a string consisting of one or more 
    * all-lowercase words separated by spaces. It should return a new string 
    * converted to "pig Latin," where each word has its first letter moved to 
    * the back and the letters "ay" are added to the end of the word. However, 
    * words starting with a vowel (a, e, i, o, or u) should not be altered.
    *
    * Examples:
    *
    * pigLatin("something")  should return "omethingsay"
    * pigLatin("awesome")    should return "awesome" (words starting with a vowel should not be altered)
    * pigLatin("latin is a hard language")  should return "atinlay is a ardhay anguagelay"
    * pigLatin("y")  should return "yay"
    * pigLatin("e")   should return "e"
    */
    public static void main(String[] args) {
        // Test cases
        assertEqual(1, pigLatin("something"), "omethingsay");
        assertEqual(2, pigLatin("awesome"), "awesome");
        assertEqual(3, pigLatin("latin is a hard language"), "atinlay is a ardhay anguagelay");
        assertEqual(4, pigLatin("y"), "yay");
        assertEqual(5, pigLatin("e"), "e");
    }

    // Implement your solution here!
    public static String pigLatin(String sentence) {

        //this is what i got in 30 minutes
        //i didn't end up being able to write any code
        //but i feel like my approach would handle the problem presented and i feel ok with that

        //words that start with vowel should not be altered
        //first letter moved to the back
        //letters ay added to end of word

        //create a return variable, pigReturn ""
        //create a tempString variable, for ay transform
        //create a string arraylist input
        //create a char arraylist mudSwap

        //my approach will be to take the string and split it into an String arraylist (tempString) so that each piece can be modified individually
            //splitting by looping through the string until you find " "
        //then i will determine the .size of the arraylist and begin looping over each piece (i = size)
        //use a for each loop to loop over each piece in input
        //for each piece of the arraylist(input) i will first check if the word starts with a vowel
            //look at the characterAt index 0 in the string
            //check it against "a","A","e","E"... if it == or .equals any of the vowels
                //if yes += it and += " " to pigReturn
                //if no
                    //split string into Char arraylist mudSwap
                        //add a copy of index 0 to arraylist (at the end of it, should be auto?)
                        //add a to arraylist
                        //add y to arraylist
                        //loop through Char arraylist starting at index 1 (important not 0!)
                            //add each char to tempString +=
                            //add tempString to pigReturn and += " "
                            //clear Char arraylist mudSwap


                //INITIAL REFLECTION post 30 minute trial//
        //my 3 big issues are:
        // 1) seems like it's gonna be n(O^3+) complexity with n being the length of the String sentence, might be n(O^2) i'll need to write it to see
                //i have a feeling i'm pretty far off of the best way to work the problem
                //
        // 2) how to write fully working code, ie : I'm not confident at all that i could remember the syntax or built in methods/tools offhand for:
                //invoking an arraylist <>() i feel like you have to put these next to eachother and declare type twice.. and its Object type not prim?
                //splitting, for something i've done dozens of times in java and javascript i can only ever remember how to do it correctly in python
                    //you either have to loop it or there's a built in .split method, but offhand i can't remember, but you split based on " " criteria
                    //adding characters to a chararray i think theres a specific method
                //CharacterAt, CharAt .("string") I would have to try a dozen attempts to get the syntax right, but i think i'd get there
                    //i think there are specific methods required to interact between strings and characters which i don't think i remember
                //little things like this i just need to practice Practice PRACTICE, i'm too reliant on a dozen 5-10 second google searches
                //
        // 3) i'm too darn slow, i feel like i understand conceptually what to do and where issues would pop up, but DOING is 90% of the battle
                //not getting anything besides a breakdown of what needed to be coded written in 30 meant that i couldn't see if my approach worked or troubleshoot/debug



        //here is the code i wrote before looking at the solution but after the 30 minutes expired

        String pigReturn = "";
        String tempString = "";
        ArrayList<Character> mudSwap = new ArrayList<>(); //new was the keyword i forgot and you only need type once in the beginning

        String[] input = sentence.split(" "); //needed to be an array not an array list to work the way i wanted, it is just .split("criteria")
        for (String word : input) { //in hindsight i could likely use toLowerCase for the comparison to short the ors
            if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u' ||
             word.charAt(0) == 'A' ||  word.charAt(0) == 'E' ||  word.charAt(0) == 'I' ||  word.charAt(0) == 'O' || word.charAt(0) == 'U') 
             {
                pigReturn += word + " ";
             } else {
                mudSwap.clear();
                for (char letter : word.toCharArray()) { //toCharArray is another one i need to drill in
                    mudSwap.add(letter);                   
                }
                mudSwap.add(mudSwap.get(0)); //.get is another one i needed to look up
                mudSwap.add('a');
                mudSwap.add('y');
                tempString = "";
                for (int i = 1; i < mudSwap.size(); i++) {
                    tempString += mudSwap.get(i);
                }
                pigReturn += tempString + " ";
             }
            }

        pigReturn = pigReturn.trim(); //remove space at the end
        return pigReturn;
        }

        //now that i've seen how it was done in pigsolution i can see that by using some more specialized methods 
        //specifically with substring i can do CONSIDERABLY less looping, also breaking my steps into more than one method


        
    }









    // Method to help with testing, you do not need to read this.
    public static void assertEqual(int testNumber, String actual, String expected) {
        if (!expected.equals(actual)) {
        System.out.println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
        } else {
        System.out.println("Test " + testNumber + " passed!");
        }
    }
  
  