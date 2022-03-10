package br.com.letscode.bookstore.model.entity;

public class Publisher {
    private String name;
    private String address;

    public Publisher(String name, String address) {
        if (name == null) {
            throw new IllegalArgumentException("Name argument is required");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address argument is required");
        }
        this.name = name.substring(0, Math.min(120, name.length()));
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
