 
public class ReferenceConstructor {
    
    public static void main(String[] args) {
        ReferenceConstructor reference = new ReferenceConstructor();
        reference.makeMemberObject();        
    }
    public void makeMemberObject(){
        MemberDTO dto1 = new MemberDTO();
        MemberDTO dto2 = new MemberDTO("Sangmin");
        MemberDTO dto3 = new MemberDTO("Sangmin","010xxxxyyyy");
        MemberDTO dto4 = new MemberDTO("Sangmin","010xxxxxxxx","god@godofjava.com");
    }
}
