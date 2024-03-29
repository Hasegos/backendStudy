<!--- 다함 --->
# TCP/IP 4계층 모델
  
* [네트워크 정리 이동](https://github.com/Hasegos/Study_CS/tree/master/Computer%20Science/NetWork)

* 목차
    * [1. 계층 구조](#계층-구조)
    * [2. 애플리케이션 계층](#애플리케이션-계층)
    * [3. 전송 계층](#전송-계층)
    * [4. 인터넷 계층](#인터넷-계층)
    * [5. 링크 계층](#링크-계층)
    * [6. 계층 간 데이터 송수신 과정](#계층-간-데이터-송수신-과정)
    * [7. PDU](#pdu)
    
<!--- 목차 1 --->
## 계층 구조

**인터넷 프로토콜 스위트(internet protocol suite)** 는 인터넷에서 컴퓨터들이 **서로 정보를 주고받는 데 쓰이는 프로토콜의 집합**이다.  
이를 설명할때, TCP/IP 4계층 혹은 OSI 7계층 모델로 설명한다.  
TCP/IP 4계층은 네트워킹 범위에 따라 네 개의 **추상화 계층**으로 구성된다.  


**TCP/IP 4계층 구조**

![1 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/88917d5e-96d6-4f5d-994a-ce31be31643c)

**TCP/IP vs OSI**  
애플리케이션 계층 -> 애플리케이션 계층, 프레젠테이션 계층, 세션 계층  
인터넷 계층 -> 네트워크 계층  
링크 계층 -> 데이터 링크 계층 , 물리 계층  
  
추가로 계층들은 특정 계층이 변경되었을때 **다른 계층이 영향 받지 않도록** 설계되어있다.  
ex) TCP 를 UDP로 변경했다고 인터넷 브라우저를 다시 설치해야하는건 아님  

---

**각 계층을 대표하는 스택**

![2 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/2e414a85-42e4-47d2-a3cc-5889302b05a4)

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)

<!--- 목차 2 --->
## 애플리케이션 계층

**애플리케이션 계층**은 **HTTP, FTP, SSH, SMTP, DNS**등 웹 서비스, 이메일등 서비스를 실질적으로 사용자에게 제공을 주로한다.  
  
**FTP** - **파일을 전송**하는데 사용되는 표준 통신 프로토콜  
**HTTP** - **웹 사이트를 이용**하는데 쓰는 프로토콜  
**SSH** - 안전하게 운영을 위한 **암호화 네트워크 프로토콜**  
**SMTP** - **전자 메일 전송**을 위한 인터넷 표준 통신 프로토콜  
**DNS** - **도메인 이름과 IP 주소를 매핑**해주는 서버    

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)

<!--- 목차 3 --->      
## 전송 계층

**전송(transport) 계층**은 **송신자**와 **수신자**를 연결하는 통신 서비스 제공과 애플리케이션과 인터넷 계층사이의 데이터를 **중계하는 역할**한다.     
대표적으로 **TCP** 와 **UDP**가 존재한다.  

### TCP

TCP는 패킷사이의 **순서를 보장하고** 연결지향 프로토콜을 사용해 **신뢰성을 구축**해서 수신 여부를 확인하는 **'가상회선 패킷 교환방식'** 을 사용한다.

#### 가상회선 패킷 교환 방식

모든 패킷을 전송하면 가상회선이 해제되고 패킷들은 전송된 **'순서대로'** 도착하는 방식을 말한다.

<img width="400" alt="1 (1)" src="https://github.com/Hasegos/Study_CS/assets/93961708/b79533c1-aa18-407e-874c-4fd08259019f">

---

### UDP

UDP는 **순서를 보장하지 않고** 수신 여부를 확인하지 않으며 단순히 데이터만 주는 **'데이터그램 패킷 교환 방식'** 을 사용한다.

#### 데이터그램 패킷 교환 방식

패킷이 독립적으로 이동하며 최적의 경로를 선택하여 가며, **'순서가 다를 수'** 있는 방식을 말한다.

<img width="400" alt="2 (1)" src="https://github.com/Hasegos/Study_CS/assets/93961708/400ac5a7-c58a-4c35-b259-dc3c0f59f80b">

---

### TCP 연결 성립 과정

TCP는 신뢰성을 확보할 떄 **'3-웨이 핸드셰이크(3-way handshake)'** 를 사용한다.

![1 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/2ea7a8c1-adc0-4070-9db3-44023b6201a3)

**1.SYN 단계** : 클라이언트가 서버에 클라이언트의 **ISN을 담아 SYN을 보낸다.**  
ISN은 새로운 TCP연결 시 첫번째 패킷에 **할당된 임의의 시퀸스 번호**이다.  
**2.SYN + ACK 단계** : 서버는 **클라이언트의 SYN을 수신**하고 **서버의 ISN을 보내며** 승인번호로 클라이언트의 ISN + 1을 보낸다.     
**3.ACK 단계** : 클라이언트는 **서버의 ISN + 1한 값인 승인번호를 담아 ACK를 서버**에 보낸다.  
  
**TCP**는 이러한 과정이 있어 **신뢰성이 있는 계층**이라고 하며 **UDP**는 이런 과정이 없어 **신뢰성이없는 계층**이라 한다.  

**SYN** - **연결 요청** 플래그  
**ACK** - **응답** 플래그  
**ISN** - **초기 네트워크 연결**할 때 할당된 **32비트 고유 시퀸스 번호**  

---

### TCP 연결 해제 과정

TCP가 연결을 해제할 떄는 **4-웨이 핸드셰이크(4-way handshake)** 을 사용한다.

![2 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/b8c205d6-c3e7-481c-95e8-73f4e5415a23)  

* **1번** : **FIN으로 설정된 세그먼트**를 보내고 클라이언트는 **FIN_WAIT_1 상태**로 들어가고 서버를 기다린다.    
* **2번** : 서버는 클라이언트에 **ACK라는 승인 세그먼트**를 보내고 서버는 **CLOSE_WAIT**로 클라이언트는 FIN_WAIT_2 상태로 들어간다.   
* **3번** : 서버는 **ACK를 보내고** 일정시간 후에 클라이언트에 **FIN이라는 세그먼트**를 보낸다.   
* **4번** : 클라이언트는 **TIME_WAIT 상태**가 되고 서버에 **ACK를 다시보내며** 서버는 **CLOSE 상태**가된다.  
    이후 어느정도 시간이 지나면 클라이언트와 서버의 **모든 자원 연결을 해제**한다.  

여기서 중요한건 **TIME_WAIT** 이다.  
첫번째는 **지연 패킷이 발생할 경우를 대비**하기위해서이다.패킷이 늦게 도착해서 데이터 100일때 50만 들어올 수 있기 때문이다.  
두번째는 두 장치가 **연결이 닫혔는지 확인**하기 위해서이다.

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)

<!--- 목차 4 --->
## 인터넷 계층  

인터넷(internet) 계층은 장치로부터 받은 **네트워크 패킷을 IP 주소로 지정된 목적지로 전송**하기위한 계층이다.   
예로는 IP, ARP, ICMP가 있으며, 상대방이 제대로 받았는지에 대해 **보장하지않는 비연결형적인 특징**을 가지고있다.  

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)

<!--- 목차 5 --->
## 링크 계층  

**링크 계층**은 전선, 광섬유, 무선 등으로 **실질적 데이터를 전달하며 장치 간에 신호를 주고받는 '규칙'** 을 정한다.  
이를 **데이터 링크 계층, 물리 계층**으로 나누기도하는데 **물리 계층**은 **0과 1로 이루어진 데이터를 보내는 계층**이며,  
**데이터 링크 계층**은 **'이더넷 프레임'** 을 통해 **에러 확인, 흐름 제어, 접근 제어하는 계층**이다.  


### 전이중화 통신

**전이중화(full duplex) 통신**은 양쪽 장치가 **동시에 송수신할 수 있는 방식**을 말한다.

![1 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/0f8ef011-5a3f-4665-a403-8d33b8f02ecf)

---

### CSMA/CD

유선 LAN에 **'반이중화 통신'** 중 하나인 **CSMA/CD(Carrier Sense Multiple Access with Collision Detection)** 방식을 사용했다.  
데이터를 보낸후 충돌이 일어나면 **일정 시간 이후 재전송하는 방식**을 사용한다.
  
**유선 LAN을 이루는 케이블**    
유선 LAN을 이루는 케이블로는 **TP케이블**이라고하는 **트위스트 페어 케이블**과 **광섬유 케이블**이 대표적이다.

---

### 트위스트 페어 케이블

**트위스트 페어 케이블(twisted pair cable)** 은 여덟개의 구리선을 **두 개씩 꼬아서 묶은 케이블**을 지칭한다. 

![2 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/9e29c4df-6c4b-4a69-ae17-41857eefe2e8)

케이블은 구리선을 **실드 처리하지않으면 UTP** 이고 **실드 처리하고 덮은 것은 STP**라 한다.
흔히 우리가 볼 수 있는 UTP는 **LAN케이블**이다.  

---

### 광섬유 케이블

**광섬유 케이블**은 **광섬유로 만든 케이블**이며, 구리와 비교할 수 없을만큼 **장거리 및 고속 통신**이 가능하다.

![3 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/40474222-2e80-4abb-b40f-dcbf49862744)

빛의 굴절률이 **높은 부분**을 **코어(core)** 이고 **낮은 부분**을 **클래딩(cladding)** 이라한다.

---

### 반이중화 통신

**반이중화 통신(half duplex)** 은 **양쪽 장치는 서로 통신**할 수 있지만, **동시에 통신할 수 없으며 한 번에 한방향만 통신**을 한다.  

![4 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/e4123680-2a27-402b-b23d-606065e17a75)

동시에 전송하면 충돌이 발생하여 메세지가 손상될 수 있으므로 **충돌방지 시스템**이 필요하다.

---

### CSMA/CA

**CSMA/CA**는 **반이중화 통신** 중 하나의 장치이며, 데이터를 보내기전에 **사전에 가능한 충돌을 방지하는 방식**을 사용한다.  

* 1 . 데이터를 송신하기 전에 무선 매체를 살핀다.
* 2 . **캐리어 감지** : 회선이 비어있는지를 판단한다.
* 3 . **IFS(Inter FrameSpace)** : 랜덤값을 기반으로 기다린다. 만약 사용중이면 그 간격을 점차 늘린다.
* 4 . 이후 데이터를 송신한다.

---

### **무선 LAN으로 이루는 주파수**  
**무선 LAN(WLAN, Wireless Local Area Network)** 은 **무선 신호 전달 방식**을 이용하여 **2대 이상의 장치를 연결**하는 기술이다.

ex) **와이파이**, **BSS**, **ESS**  

**와이파이** - 전자기기들이 **무선 LAN 신호에 연결**할 수 있게 하는 기술이다. 흔히 **공유기**라고도 한다.  
**BSS** - (Basic Service Set)은 **기본 서비스 집합**을 의미하며, BSS 내에 있는 **AP들**과 장치들이 서로 통신이 가능한 구조를 말한다.  
**ESS** - (Extended Service Set)은 **하나 이상의 연결된 BSS 그룹**을 말하며 **가용성과 이동성**을 지원한다.

![1 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/4c137525-7afb-4e04-9a39-de3811c4bf56)  

---

### **이더넷 프레임** 

**데이터 링크 계층**은 **이더넷 프레임**을 통해 전달받은 **데이터의 에러를 검출하고 캡슐화**를한다.  

![1 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/4ed25ba0-7fcf-48b4-98c9-79924d7afa60)

* **Preamble** : **이더넷 프레임이 시작**임을 알린다.
* **SFD(Start** Frame Delimiter) : 다음 바이트로부터 **MAC주소 필드가 시작**됨을 알림
* **DMAC,SMAC** : **수신, 송신 MAC주소**를 말한다.
* **EtherType** : 데이터 계층 위의 계층인 **IP프로토콜**을 정한다.
* **Payload** : **전달받은 데이터**
* **CRC** : **에러 확인** 비트 

**MAC 주소** : 컴퓨터나 노트북에 **네트워크를 연결하는 장치(LAN 카드)** 를 구별하기위한 **식별 번호**를 말한다.  

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)

<!--- 목차 6 --->
## 계층 간 데이터 송수신 과정

![1 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/7bc21205-bbdb-4e9b-9c49-cab4ee005cd3)

**송신 과정** : 애플리케이션 계층에서 전송계층으로 필자가 보내는 요청(request)값들은 **캡슐화 과정**으로 간다.  
**수신 과정** : 서버의 링크 계층에서 애플리케이션 계층까지 **비캡슐화 과정**으로 받는다.


### 캡슐화 과정

**캡슐화 과정**은 **상위 계층의 헤더**와 **하위계층의 데이터 부분**에 포함시키고 **해당 계층의 헤더를 삽입하는 과정**을 말한다.

![1](https://github.com/Hasegos/Study_CS/assets/93961708/9e6bfba9-99af-4333-9007-a9edeb60b3b6)

데이터가 전송 계층으로 전달되면서 **'세그먼트' 또는 '데이터그램'** 화 되며 **TCP(L4)헤더**가 붙여지고,  
**인터넷 계층 IP(L3)헤더**가 붙여지면서 **'패킷'화**가되며, 이후 링크 계층으로 전달되면서 **프레임 헤더와 프레임 트레일러가 붙어 '프레임'화**가된다.  

---

### 비캡슐화 과정

**비캡슐화 과정**은 하위 계층에서 상위 계층으로 가면서 **각 계층의 헤더부분을 제거**하는 과정을 말한다.

![2](https://github.com/Hasegos/Study_CS/assets/93961708/c3cd433e-b980-47fa-8a2f-f84273d06801)

캡슐화된 데이터가 올라오면서 **프레임화된 데이터를 다시 패킷화**를 거쳐서 **세그먼트, 데이터그램화를 거쳐 메세지화**가되는 **비캡슐화 과정**이 일어난다.  
이후 사용자에게 애플리케이션의 **PDU 메세지**로 전달한다.  

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)

<!--- 목차 7 --->
## PDU

**네트워크의 어떤한 계층에서 계층으로 데이터가 전달**될 때 **한덩어리의 단위를 PDU(Protocol Data Unit)** 라고한다.  
**PDU**는 **제어 관련 정보들이 포함된 '헤더'**, **데이터를 의미하는 '페이로드'** 로 구성되어있다.  

* **애플리케이션 계층** : 메세지
* **전송 계층** : 세그먼트(TCP), 데이터그램(UDP)
* **인터넷 계층** : 패킷 
* **링크 계층** : 프레임(데이터 링크 계층), 비트(물리 계층)

해당 [PDU 테스팅](https://reqbin.com/curl) 사이트를 통해 **HTTP 요청을 해서 PDU 테스팅**을할 수 있다.  
PDU 중 **아래 계층인 비트로 송수신하는 것이 모든 PDU중 가장 빠르고 효율성이 높다.**  
하지만 **애플리케이션**에서는 **문자열을 기반으로 송수신**하며, 그 이유는 **헤더에 authorization값 등 다른 값들을 넣는 확장이 쉽기** 때문이다.  

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#tcpip-4계층-모델)
