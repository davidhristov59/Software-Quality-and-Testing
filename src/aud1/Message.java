package aud1;

public class Message {

    //option + enter = create test na message

    private String message;

    public Message(String message) {
        this.message = message;
    }

    //da bese void ke bese tezok za testiranje
    //vaka so String e polesno za testiranje , koga vraka nekoj rezultat

    public String salutationMessage(){
        this.message = "Hello!";
        return this.message;
    }

    public String goodbyeMessage() {
        this.message = "Goodbye!";
        return this.message;
    }

    public String setMessage(String message) {
        this.message = message;
        return this.message;
    }

}
