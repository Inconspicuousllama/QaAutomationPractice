package streamApi;

public class PhoneData {
    private String numberId;
    private String response;
    private String phoneNumber;

    public String getNumberId() {
        return numberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return response;
    }

    public PhoneData(String response) {
        this.response = response;
    }
}
