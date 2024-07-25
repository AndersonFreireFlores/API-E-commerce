package andersonfflores.ecommerce.Models.User.Enum;

public enum UserRole {

    ADMIN(1),
    USER(2);

    private int role;

    UserRole(int role){
        this.role = role;
    }

    public int getRole(){
        return role;
    }

    public static UserRole fromInt(int role) {
        switch(role) {
            case 1: return ADMIN;
            case 2: return USER;
            default: throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}
