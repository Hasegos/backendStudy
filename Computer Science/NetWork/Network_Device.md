<!---다함--->
# 네트워크 기기

* [네트워크 정리 이동](https://github.com/Hasegos/Study_CS/tree/master/Computer%20Science/NetWork)

* 목차
    * [1. 네트워크 기기의 처리 범위](#네트워크-기기의-처리-범위)
    * [2. 애플리케이션 계층을 처리하는 기기](#애플리케이션-계층을-처리하는-기기)
    * [3. 인터넷 계층을 처리하는 기기](#인터넷-계층을-처리하는-기기)
    * [4. 데이터 링크 계층을 처리하는 기기](#데이터-링크-계층을-처리하는-기기)
    * [5. 물리계층을 처리하는 기기](#물리계층을-처리하는-기기)

<!---목차 1--->
## 네트워크 기기의 처리 범위

네트워크 기기는 계층별 처리 범위를 나눌 수 있다.  
예를들면 "물리 계층을 처리하는 기기, 데이터 링크 계층을 처리하는 기기"  
그리고 **상위 계층을 처리하는 기기는 하위 계층을 처리할 수 있다.**  
반면 **하위 계층이 상위계층을 처리할 수는 없다.**  

+ **애플리케이션 계층** : L7 스위치
+ **인터넷 계층** : L3 스위치
+ **데이터 링크** 계층 : L2 스위치, 브리지
+ **물리 계층** : NIC, 리피터, AP

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#네트워크-기기)


<!---목차 2--->
## 애플리케이션 계층을 처리하는 기기

**애플리케이션 계층**을 처리하는 기기로는 **L7 스위치**가 있다.  

### L7 스위치

스위치는 **여러 장비를 연결**하고 **데이터 통신을 중재하며**    
**목적지가 연결된 포트로만 전기 신호를 보내 데이터를 전송하는 통신 네트워크 장비**이다.    

<img width="430" alt="1" src="https://github.com/Hasegos/Study_CS/assets/93961708/af36c173-ae2e-41c3-afae-e479994d7e23">  

L7 스위치는 **로드밸런서** 라고도하며, **서버의 부하를 분산**하는 기기이다.   
요청들을 뒤쪽의 여러 서버로 나누며, **시스템이 처리할 수 있는 트래픽 증가**를 목표로한다.  

분산할때 **URL, 서버, 캐시, 쿠키**들을 기반으로 트래픽을 분산하며,  
만약 서버에 장애가 발생시 **헬스 체크(Health Check)** 를 통해 감시가 이루어진다.  

---

### L4 스위치와 L7 스위치 차이

**L4 스위치**는 **전송 계층**을 처리하는 기기이고, L7 와 같이 **로드밸런서**라고한다.  
L4 스위치는 L7 스위치와 다르게 **IP/ 포트(특히나 포트)기반으로 트래픽을 분산한다.**  

그리고 L7 스위치의 **로드밸런싱은 ALB(Application Load Balancer) 컴포넌트**로 한다.  
반면 L4 스위치는 **로드밸런싱은 NLB(Network Load Balancer) 컴포넌트**로 한다. 

---

### 헬스 체크

L4 스위치 또는 L7 스위치 모두 **헬스 체크**를 통해 **정상적인 서버 또는 비정상적인 서버를 판별하며**,  
**헬스 체크**는 **전송 주기와 재전송 횟수 등을 설정한 이후 반복적으로 서버에 요청**을 한다.

예를 들어 TCP 요청을 보냈는데, 만약 **3-웨이 핸드셰이크가 정상적으로 일어나지 않았다면** 정상적인 상황이아니다.

---

### 로드밸런서를 이용한 서버 이중화

서비스를 안정적으로 운용하기위해서는 2대 이상의 서버가 필수적이다.  
이를 위해 로브밸런서를 **서버 이중화**를 사용한다.

![2](https://github.com/Hasegos/Study_CS/assets/93961708/55d6a22c-5469-4964-bf2b-59551fb6c2f1)

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#네트워크-기기)

<!---목차 3--->
## 인터넷 계층을 처리하는 기기

인터넷 계층을 처리하는 기기로는 **라우터, L3 스위치**가 있다.  

### 라우터

**라우터(router)** 는 여러개의 **네트워크를 연결, 분할, 구분**시켜주는 역할을 하며,  
다른 네트워크 끼리 주고받을때 **"패킷 소모를 최소화하고 경로를 최적화하여 최소 경로로 패킷을 포워딩"** 하는 라우팅 장비이다.  

![unnamed (1)](https://github.com/Hasegos/Study_CS/assets/93961708/2430cfba-1d36-48ef-83b2-40df1d8acc11)

---

### L3 스위치

L3 스위치란 **L2 스위치의 기능과 라우팅 기능**을 갖춘 장비이며, L3 스위치는 **라우터**라고 해도 무방하다.  

|구분| L2스위치| L3 스위치|
|---|---|---|
| 참조 테이블 | MAC 주소 테이블 | 라우팅 테이블 |
| 참조 PDU | 이더넷 프레임 | IP 패킷 |
| 참조 주소 | MAC 주소 | IP 주소 |

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#네트워크-기기)

<!---목차 4--->
## 데이터 링크 계층을 처리하는 기기

데이터 링크 계층을 처리하는 기기로는 **L2 스위치와 브리지**가 있다.  

### L2 스위치

L2 스위치는 장비들의 **MAC 주소를 MAC 주소 테이블**을 통해 관리하며, **패킷 전송**을 담당한다.  

![4 (1) (1)](https://github.com/Hasegos/Study_CS/assets/93961708/09fa2e23-a413-4ae2-9d6f-9e1b99f7a43e)

IP 주소를 이해하지 못해 **IP 주소를 기반으로 라우팅은 불가능**하며 **패킷의 MAC 주소**를 읽어 스위칭하는 역할을 한다.  
만약 MAC 주소 테이블이 없다면 전체 포트에 전달후 MAC 주소 테이블을 일정시간 이후 삭제하는 기능이있다.

---
### 브리지

**브리지(bridge)** 는 두개의 근거리 통신망(LAN)을 상호 접속할 수 있는 **통신망 연결장치**로,  
**MAC주소를 MAC 주소 테이블**로 관리한다. 즉,**하나의 통신망**을 구축할때 사용한다.

![5 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/2e829d8b-694f-439a-91d0-0cbf4a300d3e)

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#네트워크-기기)

<!---목차 5--->
## 물리계층을 처리하는 기기

물리 계층을 처리하는 기기는 **NIC, 리피터, AP**가 있다.  

### NIC

**LAN 카드**라고 하는 네트워크 인터페이스 카드(NIC, Network Interface Card)는 **2대 이상의 컴퓨터 네트워크 구성**하는데 사용한다.  

![6 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/4272166f-55b2-4f0e-a047-6661317eca3a)

LAN 카드에는 주민등록번호처럼 각각을 구분하기 위한 고유의 식별번호인 **MAC 주소**가 있다.

---

### 리피터

리피터(repeater)는 들어오는 약해진 신호 정도를 증폭하여 다른쪽으로 전달하는 장치이다.  

![7](https://github.com/Hasegos/Study_CS/assets/93961708/aa3e3b23-a68b-42ab-99ad-2280070fbd85)

---

### AP

AP(Access Point)는 **패킷을 복사하는 기기**이다.

![8](https://github.com/Hasegos/Study_CS/assets/93961708/c8116ab2-a020-454e-a034-8cf53146d574)

![arrow_up_circle_icon_128946 (1)](https://github.com/Hasegos/Study_CS/assets/93961708/56bc983f-ea61-48fc-b733-fb8118b3aad5)[목차로 돌아가기](#네트워크-기기)