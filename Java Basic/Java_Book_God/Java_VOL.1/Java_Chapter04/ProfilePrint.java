
public class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;
    
    public static void main(String[] args) {
        ProfilePrint profile = new ProfilePrint();
        byte age = 22;
        String name = "최수호";
        boolean isMarried = false;
            
        profile.setAge(age);
        profile.setName(name);
        profile.setMarried(isMarried);
        
        System.out.println(profile.getAge());
        System.out.println(profile.getName());
        System.out.println(profile.isMarried());
        
    }
    public void setAge(byte age){
        this.age = age;
    }
    public byte getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setMarried(boolean flag){
        isMarried = flag;
    }
    public boolean isMarried(){
        return isMarried;
    }
}
