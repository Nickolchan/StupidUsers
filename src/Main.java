interface CommonPhrase {
    void sayCommonPhrase();
}

abstract class User implements CommonPhrase {
    protected int brutality;
    protected int conviction;

    public int getBrutality() {
        return brutality;
    }

    public int getConviction() {
        return conviction;
    }

    protected String name;

    public String getName() {
        return name;
    }


    User(String name) {
        this.name = name;
    }

    void say(String phrase) {
        System.out.println(this.name + " says: " + phrase);
    }

    //interface
    void giveUp() {
        this.say("You`re right, pal");
    }

    void lowerBrutality(int conviction) {
        this.sayCommonPhrase();
        if (conviction < this.brutality) {
            this.brutality -= conviction;
        } else {
            this.brutality = 0;
            this.conviction = 0;
            this.giveUp();
        }

    }

    void convince(User someone) {
        if (this != someone) {
            if (this.conviction > 0) {
                someone.lowerBrutality(this.conviction);
            } else {
                this.say("I've run out of conviction");
            }
        } else {
            this.say("I will not hurt myself!!! :(");
        }
    }

}

class Linuxoid extends User {

    Linuxoid(String name) {
        super(name);
        this.brutality = 100;
        this.conviction = 10;
    }

    @Override
    public void sayCommonPhrase() {
        this.say("Looks like your PC is damaged by virus lol:)");
    }
}

class WindowsUser extends User {
    WindowsUser(String name) {
        super(name);
        this.brutality = 80;
        this.conviction = 5;
    }

    @Override
    public void sayCommonPhrase() {
        this.say("Haha, I've got Witcher 3 installed!");
    }
}

class AppleGlor extends User {
    AppleGlor(String name) {
        super(name);
        this.brutality = 5;
        this.conviction = 1;
    }

    @Override
    public void sayCommonPhrase() {
        this.say("Steve Jobs mf");
    }

    void giveUp() {
        this.say("Screw you guys, I'm going home!!!");
    }
}

class TestGame {
    Linuxoid linuxoid;
    AppleGlor appleGlor;
    WindowsUser windowsUser;

    TestGame() {
        linuxoid = new Linuxoid("Peter the linuxoid");
        appleGlor = new AppleGlor("Vovan the appleglor");
        windowsUser = new WindowsUser("Oleg the Windowser");
    }

    private void printStatLine(User user) {
        System.out.println(user.getName() + "\t" + user.getBrutality() + "\t" + user.getConviction());
    }

    public void printStats() {
        System.out.println("\nStats sheet:");
        System.out.println("Name\t\t\t\tBrutality\tConviction");
        printStatLine(linuxoid);
        printStatLine(windowsUser);
        printStatLine(appleGlor);
    }

    public void play() {
        appleGlor.convince(linuxoid);
        linuxoid.convince(windowsUser);
        windowsUser.convince(appleGlor);
        appleGlor.convince(linuxoid);
        linuxoid.convince(linuxoid);
    }
}


public class Main {
    public static void main(String[] args) {
        TestGame testGame = new TestGame();

        testGame.play();
        testGame.printStats();
    }
}
