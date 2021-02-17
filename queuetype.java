
public class queuetype {

	public static String queue(int key) {
		String quetype ;
		switch (key) {
		case 0 : 
			return quetype = "커스텀게임"; 
		case 430: 
			return quetype ="일반게임"; 
		case 420: 
			return quetype ="솔로랭크"; 
		case 440: 
			return quetype ="자유랭크"; 
		case 900: 
			return quetype ="우르프모드"; 
		case 830: 
			return quetype ="입문 AI"; 
		case 840: 
			return quetype ="초급 AI"; 
		case 850: 
			return quetype ="중급AI"; 
		case 450: 
			return quetype ="무작위 총력전"; 
//		case : 
//			return quetype =""; 

		default:
			return quetype ="기타게임"; 
		}
		
		
		
	}
	
	
}
