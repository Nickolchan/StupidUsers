class User {
    protected int brutality;
    protected int conviction;
    protected String name;
    protected String commonPhrase;

    void say(String phrase) {
        System.out.println(this.name + " says: " + phrase);
    }

    void giveUp() {
        this.say("You`re right, pal");
    }

    void lowerBrutality(int conviction) {
        this.say(this.commonPhrase);
        if (conviction < this.brutality) {
            this.brutality -= conviction;
        } else {
            this.brutality = 0;
            this.conviction = 0;
            this.giveUp();
        }

    }

    void convince(User someone) {
        if (this.conviction > 0) {
            someone.lowerBrutality(this.conviction);
        } else {
            this.say("I've run out of convction");
        }
    }

    User(String name) {
        this.name = name;
    }


}

class Linuxoid extends User {
    Linuxoid(String name) {
        super(name);
        this.brutality = 100;
        this.conviction = 10;
        this.commonPhrase = "Looks like your PC is damaged by virus lol:)";
    }

}

class WindowsUser extends User {
    WindowsUser(String name) {
        super(name);
        this.brutality = 80;
        this.conviction = 5;
        this.commonPhrase = "Haha, you're gonna use Wine forever!";
    }
}

class AppleGlor extends User {
    AppleGlor(String name) {
        super(name);
        this.brutality = 0;
        this.conviction = 1;
        this.commonPhrase = "Steve Jobs mf";
    }
    void giveUp() {
        this.say("Screw you guys, I'm going home!!!");
    }
}


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
