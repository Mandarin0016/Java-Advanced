package CustomStack;


public class Test {
    public static void main(String[] args) {
        CustomStack<String> customStack = new CustomStack<>(String.class);
        //push elements into the stack:
        customStack.push("Luna Lovegood"); // ["Luna Lovegood", "null", "null", "null"]
        customStack.push("Rubeus Hagrid"); // ["Rubeus Hagrid", "Luna Lovegood", "null", "null"]
        customStack.push("Dean Thomas"); // ["Dean Thomas", "Rubeus Hagrid", "Luna Lovegood", "null"]
        customStack.push("Molly Weasley"); // ["Molly Weasley", "Dean Thomas", "Rubeus Hagrid", "Luna Lovegood"]
        //pop element from the custom stack:
        System.out.printf("%s is a brave magician and lovely mom!%n", customStack.pop()); // will return and remove the string "Molly Weasley" and the stack will look like this:  ["Dean Thomas", "Rubeus Hagrid", "Luna Lovegood", "null"]
        //peek element from the custom stack:
        System.out.printf("Did you know that %s is a half-blood wizard, the son of a wizard and a Muggle?%n", customStack.peek()); // will return the string "Dean Thomas" to the console, but won't remove it from the stack
        //iterate through every element into the stack:
        System.out.println("Let's cast the Patronus Charm!");
        customStack.forEach(wizard -> System.out.printf("%s: Expecto Patronum!%n", wizard));
        //get the size of the custom stack:
        System.out.printf("Our party contains %d wizards!", customStack.getSize());
    }
}
