# TaskManager


### 프로젝트 핵심 개념
회사 또는 커뮤니티에서 프로젝트를 협업하고 관리하는 시스템 개발


### 주요 기능
A.  사용자 관리
- 로그인 / 로그아웃
- 사용자 관리 (등록 / 삭제)

B.  업무 관리
- 과제 등록/수정 (시작 날짜 & 마감 날짜 / 할당 멤버 / 작업 내용)   
- 팀 멤버에게 할당 
- 작업 완료 표시 
- 현재 진행중인 과제 (과제의 달성률, 진행 정도)

C.	회의 관리
- 회의 기록 (날짜, 장소, 참여 멤버, 회의 내용, 회의 결과)
	     - 회의 기록 읽기 /수정
- 회의용 첨부파일
	     - 회의들의 목록 보여주기 (날짜 별로 정렬)
       
D.	스케줄 관리
- 스케줄 생성 / 수정
- 스케줄 일정 확인 (달력식)
- 스케줄 알림 (팝업 알림)
(* 스케줄 정렬 기능)

E.	옵션 바꾸기
-	폰트 타입 & 크기 변경


### Usecase diagram
![image](https://user-images.githubusercontent.com/36908476/86515901-6f7b3880-be57-11ea-8c49-0004a50da54c.png)

### Usecase scenario

그룹 만들기
1. Actor    ->   Host

2. 개요
    -이 상황은 호스트가 그룹을 만들려할 때 발생한다.

3. 사전조건
    -호스트는 로그인 상태여야한다.

4. 사후조건
    -없음

5. Main scenario
    1) 호스트가 그룹만들기를 기능을 이용해 그룹 생성을 시작한다.
    2) 그룹명을 입력한다.
    3) 그룹에 속할 멤버를 선택한다.
    4) 그룹이 생성된다.

6. Alternative scenario
    -없음

7. Exceptional scenarios
    E1. 호스트가 로그인 되어있지 않은 경우
  		1) “로그인 후 이용가능합니다” 메세지를 출력한다.
  		2) 로그인 페이지로 돌아간다.
    E2. 그룹 생성을 취소한 경우
  		1) 그룹 멤버 정보를 삭제한다.
 		2) 그룹명 정보를 삭제한다.
  		3) 메인 화면으로 돌아간다.

과제 등록하기
1. Actor     ->     Host

2. 개요
    -이 상황은 호스트가 그룹에 과제를 등록하려할 때 발생한다.

3. 사전조건
    -호스트는 로그인 상태여야한다.
    -호스트는 그룹에 소속된 상태여야한다.
    	    -사용자는 호스트여야한다.

4. 사후조건
    -없음


5. Main scenario
    1) 호스트가 그룹에 들어간다.
    2) 업무 관리 기능을 시작한다.
    3) 과제 등록 기능을 실행한다.
    4) 과제의 이름을 등록한다.
    5) 시작날짜를 설정한다.
    6) 마감날짜를 설정한다.
    7) 작업내용을 입력한다.
    8) 작업을 멤버에게 할당한다.
    9) 과제 등록을 마친다.

6. Alternative scenario
    5a) 시작날짜가 현재 날짜 이전이다.
     		5a1. 시작날짜를 다시 입력하라는 알림창을 띄운다.
      		5a2. 입력한 시작날짜를 초기화시킨다.
      		5a3. 사용자는 이에 대해 통지받고, 날짜를 다시 입력한다.
    8a) 과제 할당을 지정하지 않을 경우
       		8a1. “과제 할당을 지정하지 않았습니다. 이대로 계속하시겠습니까?” 
알림창을 띄운다.
      		8a2-1. 사용자가 확인을 누른다면 과제 등록을 마친다.
       		8a2-2. 사용자가 취소를 누른다면 과제 할당을 진행하게 한다.

7. Exceptional scenarios
    E1. 과제 등록을 취소한 경우
  		1) 할당 정보를 삭제한다.
  		2) 작업 내용을 삭제한다.
  		3) 시작, 마감 날짜를 삭제한다.
 		 4) 과제 이름을 삭제한다.
  		5) “과제 등록이 취소되었습니다.” 메세지를 띄운다.
  		6) 그룹 페이지로 돌아간다.

회의 기록 읽기
1. Actor    ->     User

2. 개요
    -이 상황은 사용자가 회의 기록을 읽으려고 할 때 발생한다.
3. 사전조건
    -사용자는 로그인 상태여야한다.
    -사용자는 해당 그룹에 소속된 상태여야 한다.

4. 사후조건
    -없음

5. Main scenario
    1) 사용자가 그룹에 들어간다.
    2) 회의 관리 기능을 시작한다.
    3) 회의 기록 읽기 기능을 실행한다.
    4) 읽기 원하는 회의 기록을 선택한다.
    5) 회의 기록을 읽는다.
    6) 회의 기록 읽기를 종료한다.

6. Alternative scenario
	     -없음

7. Exceptional scenarios
     E1. 회의 기록을 읽던 중 다른 사용자에 의해서 회의 기록이 수정된 경우
  1) “해당 회의기록이 수정되었습니다. 수정된 내용을 불러오시겠습니까?” 메세지를 출력한다.
  2-1) 사용자가 “예”를 누른 경우, 회의기록을 다시 불러온다.
  2-2) 사용자가 “아니오”를 누른 경우, 화면을 유지한다.


### Class Description and Class diagram
A.Initial class
-로그인 Instance 생성
-로그인시 메뉴 instance 생성 후 메인 메뉴로 이동

main(String[] args) : 메인 method
gotoMenu(UserDTO user) : 로그인시 메뉴로 이동, user정보를 전달한다.

B. Login class
-로그인 창 GUI 구성
-로그인 기능 실행 (유저 로그인 정보 일치 여부 확인)
-SignUp instance 생성, 회원가입 페이지로 이동 가능

isLoginCheck() : 아이디가 올바른지 check
setMain() : main process와 연동을 위한 method
isLogin() : 로그인 
Login getInstance() : Singleton 패턴 - Login 객체를 생성하여 반환하는 method

C. SignUp class
-유저로부터 정보를 입력받고 회원가입
-회원 가입이 성공시 유저 정보는 파일로 저장

signUp() : 회원가입 창 전체 구성
D. ManageGroup class
-그룹 선택 , 그룹 생성, 그룹 관리를 할 수 있는 창 구성

screen(UserDTO user) : 창에 그룹 관련 메뉴들을 보여줌

E. MakeGroup class
-그룹 생성 창을 구성
-그룹 이름, 멤버, 종류 선택 가능

make(String name) : 그룹 생성, parameter로 user name을 받아 host로 지정

F. UserDAO class
-user 정보를 file에 저장하고 가지고 오는 기능을 담당하는 class

getUserUsingId(String id) : id를 이용해 file에서 해당 user 정보를 찾아내 객체를 반환한다.
addUser(String name, String id, String password, String departmentm String intro) : 입력받은 정보를 file에 저장한다.


G. UserDTO class
-user 정보를 set, get하는 method

get[Field] : getter()
set[Field] : setter()


H. ScheduleMenu class
 -스케줄 관리를 눌렀을때 스케줄 생성 및 수정을 할 수 있는 창 구성

screen() : 창에 스케줄 관련 메뉴들을 보여줌
actionPerformed() : 버튼을 누를 시 action을 연결해줌


I. Schedule class
	- 유저, 스케줄 파일에서 정보를 받아서 MakeSchedule에서 사용가능하게 해줌
	
	Schedule(): constructor이다.
	getSchedule(): 파일에서 스케줄 이름을 가져온다.
	getDate(): 파일에서 날짜와 시간을 가져온다.
	getContent(): 파일에서 스케줄의 내용을 가져온다.

J. GroupDAO class
-user 정보를 file에 저장하고 가지고 오는 기능을 담당하는 class

getGroupUsingName(String name) : name을 이용해 file에서 해당 group 정보를 찾아내 객체를 반환한다.
addGroup() : MakeGroup class에 있는 group 정보 저장 코드를 추후 옮길 예정

K. GrouprDTO class
-group 정보를 set, get하는 method

get[Field] : getter()
set[Field] : setter()

L. Group, SchoolGroup, CompanyGroup, OtherGroup class
-group 객체 group 생성시 선택한 category에 따라 세 그룹으로 나눠진다. SchoolGroup, CompanyGroup, OtherGroup은 Group을 부모 class로 가진다.

	abstract void ManageMember();
	abstract void ManageTask();
	abstract void ManageSchedule();
	abstract void ManageMeeting();

	@Override
	void ManageMember()
	@Override
	void ManageTask()
	@Override
	void ManageSchedule()
	@Override
	void ManageMeeting()

-> Group에서는 abstract method로 위의 method를 가지고 이는 각 자식 class에서 구현됨으로 완성된다.



M. GroupFactory, SchoolGroupFactory, CompanygroupFactory, OtherGroupFactory class
-group을 생성하는 Factory. SchoolGroupFactory, CompanyGroupFactory, OtherGroupFactory은 GroupFactory을 부모 class로 가진다.

createGroup: 그룹을 생성하는 method. 생성하고자 하는 group의 종류에 따라 group을 만드는 Factory가 다르다.

N. TaskMenu class 
Task Create, Read, Update, Delete를 할 수 있는 페이지로 이동 가능하게 하는  창을 구성 
	(MakeTask, ShowTask class와 연동)

O. ShowTask class 
Task를 확인하고 수정 및 삭제까지 할 수 있는 기능. 

updateFile(int rowInt) : 테이블뷰에서 마우스로 클릭한 index값을 받고 입력 값에 따라 해당 index에 해당하는 task를 수정한다.  
deleteFile(int rowInt) : 테이뷰에서 마우스로 클릭한 index값을 받고 해당 index에 해당하는 task를 파일에서 지운다.

P. MakeTask class
파일을 읽고 task를 입력 받아 파일에 이어 쓰는 기능.

Q. Task class
task 정보를 담고 있는 class

	getTask(), setTask(String task)
	getStartDate(), setStartDate(String startDate)
	getEndDate(), setEndDate(String endDate)
	getUserList(), setUserList(ArrayList<String> userList)

R. Observer, TaskObserver, MeetingObserver, ScheduleObserver class
옵저버들이 관찰 대상인 subject 객체들을 관찰해서 변동이 생기면 notify()를 실행합니다.
Observer는 interface이고 나머지 클래스들은 Observer를 implement하여서 구현하였습니다.


S. Subject, Subscriber class
감시자인 Observer class들에게 감시를 받고 있는 클래스들입니다.
Subject interface를 Subscriber가 implement합니다.
subscribe()를 통해서 observer와 연결되고 unsubscribe()를 통해 감시가 해제됩니다.



T. [State design pattern] Season, Background, Spring, Summer, Autumn, Winter class
State( Spring, Summer, Autumn, Winter)에 따라서 Background의 changeBackground method의 구현이 바뀜. ( Background를 implements 함)
Background는 interface 역할
Season은 setBackground method를 통해 state를 입력받음.

U. [Decorate design pattern] DecoName, JustName, IsLeaderTopping, InChargeTopping, Topping Class
DecoName에서는 getName, setName method를 관리.
isLeaderTopping, InChargeTopping class는 Topping을 extends한다.
Topping class는 DecoName class를 implements한다. 

V. [Memento design pattern] Memento, Originator, CareTaker, Setting Class
Memento : 특정 시점의 Originator 상태 정보를 저장하는 클래스. 메멘토의 상태는 외부에 노출하지 않게 한다.
CareTaker : 상태 정보가 저장되어 있는 Memento들을 관리하고 내부의 Stack 자료형 변수를 가짐으로써 Memento 객체를 저장하고 복원함.
Originator : Memento 객체를 생성하고 Originator의 snapshot을 저장.
Setting : 메인 화면에서 환경설정을 통해 폰트를 바꿀 수 있고 메멘토 디자인 패턴을 통해 되돌아가기를 할 수 있다.

W. [Visitor design pattern] Element, Visitor, VisitorImpl, Client Class
Element: visitor 패턴에서 client class를 통해 사용되는 interface이고  concrete class로 Group과 schedule이 있다. accept 메서드를 오버라이드 하게 해준다.
Visitor: 방문자 interface이다. visit이라는 메서드dml overloading이 일어나서 parameter에 따라 다른 기능을 갖게 한다.
VisitorImpl: Visitor를 implement하는 class이다. visit의 parameter별로 다른 기능/연산들이 구현되어 있다.
Client: visitor클래스의 메인 바디로 보면 됩니다. Visitor.visit을 호출하여서 연산을 하고 다시 element인 그룹과 클래스로 넘겨준다.

X. [Command design pattern] Receiver, Command, TaskCommand, ScheduleCommand class,  MeetingCommand
Client 역할은 Menu class가 담당
Receiver
Command
TaskCommand
ScheduleCommand
MeetingCommand 

Y. MeetingDTO  Class
	-meeting 정보를 set, get하는 method
get[Field] : getter()
set[Field] : setter()

Z. MeetingMenu  Class
 -회의 기록 관리를 눌렀을때 회의 기록 생성 및 수정을 할 수 있는 창 구성
screen() : 창에 회의기록 생성, 회의 목록 보여주기 버튼을 보여줌
actionPerformed() : 버튼을 누를 시 action을 연결해줌

AA. MakeMeeting  Class
	 -새로운 회의기록을 사용자로부터 입력받고 입력받은 정보를 txt파일에 기록하는 
   class

AB. ShowMeeting  Class
	-Meeting를 확인하고 수정 및 삭제까지 할 수 있는 기능. 
updateFile(int rowInt) : 테이블뷰에서 마우스로 클릭한 index값을 받고 입력 값에 따라 해당 index에 해당하는 meeting를 수정한다.  
deleteFile(int rowInt) : 테이뷰에서 마우스로 클릭한 index값을 받고 해당 index에 해당하는 meeting를 파일에서 지운다


![image](https://user-images.githubusercontent.com/36908476/86515929-a3eef480-be57-11ea-9222-be12d13d87ed.png)


### 적용한 Design Pattern

##### 1 - Singleton Design Pattern

Singleton 디자인 패턴은 전역변수를 사용하지 않고 객체를 하나만 생성하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴입니다.
로그인 객체는 여러개가 생성될 필요가 없기에, 로그인 클래스에 최초 한번만 메모리를 할당하고 생성자가 여러 차례 호출되더라도 최초에 생성된 객체를 반환하게 했습니다. getInstance() method를 실행하면 loginInstance가 반환됩니다.

##### 2 - Template Method Design Pattern
Template Mehotd Design pattern은 어떤 작업을 처리하는 일부분을 서브 클래스로 캡슐화해 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴입니다. 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 method의 코드 중복을 최소화 할 때 유용합니다.
즉, 동일한 기능을 상위 클래스에서 정의하면서 확장/변화가 필요한 부분만 서브 클래스에서 구현할 수 있도록 한 것입니다.

Group은 SchoolGroup, CompanyGroup, OtherGroup으로 구성되고 이들 각각은 Group을 inherit합니다.  getter와 setter들은 모든 그룹에 적용되는 기능이기에 상위 클래스인 Group에서 정의했습니다. 하지만 그룹별로 설명에 차이가 있습니다. 설명을 반환하는 method를 getEx()로 두었습니다. Group에서는 이 method가 abstract method로 정의되어있으며 이는 각각 School, Company, Other 그룹의 구현을 통해 완성됩니다.


##### 3 - Factory Method Design Pattern
Factory Method Pattern에서는 객체를 생성하기 위한 Interface/Abstract Class를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만듭니다. 팩토리 메소드 패턴을 이용하면 인스턴스를 만드는 일을 서브클래스에 맡기게 되는 것입니다. 

##### 4 - Observer design pattern 

Observer design pattern이란 behavioral pattern으로써 객체의 상태 변화를 관찰하는 관찰자들, 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴이다.
주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다. 발행/구독 모델로 알려져 있기도 하다.
이 패턴의 목적은 객체 사이에 일 대 다의 의존 관계를 정의해 두어, 어떤 객체의 상태가 변할 때 그 객체에 의존성을 가진 다른 객체들이 그 변화를 통지 받고 자동으로 갱신될 수 있게 만듭니다.
이 패턴의 핵심은 옵저버 또는 리스너(listener)라 불리는 하나 이상의 객체를 관찰 대상이 되는 객체에 등록시킨다. 그리고 각각의 옵저버들은 관찰 대상인 객체가 발생시키는 이벤트를 받아 처리한다.
본 프로젝트에서는 옵저버 패턴이 주로 사용되는 유투브등의 구독 모델과 매우 유사하게 구현하였습니다. 구독자를 Task, Schedule, Meeting에 모두 만들어서 각자 변화가 있을 때 알림이 가도록 구현하였습니다.

##### 5 - State design pattern
State Pattern은 객체가 특정 상태에 따라 행위를 달리하는 상황에서, 자신이 직접 상태를 체크하여 상태에 따라 행위를 호출하지 않고, 상태를 객체화 하여 State가 행동을 할 수 있게 위임하는 패턴입니다. 
여기서 State는 객체가 가지는 조건이나 상황을 뜻합니다.

Run-time때 State에 따라서 action이 변합니다. 따라서 Task Management에서는 계절을 선택하고 선택한 값 (상태)에 따라서 배경색을 변경하는 방식으로 사용하였습니다. Run-time때 유저가 누르는 값에 따라서 action이 바뀝니다.    

본 프로젝트에서 State design pattern을 사용한 이유는 run time때 유저가 누르는 값에 따라서 배경을 변경해야 할때 적용할 수 있을것이라 생각했고 스테이트 디자인 패턴을 사용했을때 효율적으로 봄,여름,가을,겨울 을 재사용하고 유용하게 사용할 수 있을것이라 생각해서 적용하였습니다.

##### 6 - Decorator design pattern 
Decorator Pattern은 Structural design pattern중 하나로 객체의 결합을 통해 기능을 동적으로 유연하게 확장 할 수 있게 해주는 패턴입니다. 기본 기능에 새로운 기능을 추가할 때, 서브 클래스를 생성하는 것보다 주어진 상황 및 용도에 따라 동적으로 객체에 책임을 덧붙입니다.
Component는 기본 기능을 뜻하는 ConcreteComponent와 추가 기능을 뜻하는 Decorator의 공통 기능을 정의합니다. 즉, 클라이언트는 Component를 통해 실제 객체를 사용합니다.
ConcreteComponent는 기본 기능을 구현한 클래스입니다. 화장품과 쌩얼의 관계를 예시로 들자면 쌩얼에 속합니다.
Decorator는 많은 수가 존재하는 구체적인 Decorator의 공통 기능을 제공합니다. Filter이며 화장품입니다.
ConcreteDecoratorA, ConcreteDecoratorB는 Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻합니다. 

데코레이터 기능을 사용한 이유는 기본적인 기능에 추가적으로 리더인지, 맡은 직책이 무엇인지를 추가하는 과정속에서 데코레이터 패턴을 사용하면 손쉽게 구현할 수 있을것이라 생각했습니다.


##### 7 - Memento Design Pattern 
메멘토 디자인 패턴은 객체를 이전 상태로 되돌릴 수 있는 기능을 제공하는 디자인 패턴입니다.

3개의 객체로 구현되는데 Originator, Caretaker, Memento 입니다. Originator는 memento 객체를 생성해서 originator의 snapshot을 저장합니다. 
Caretaker는 상태 정보가 저장되어 있는 memento들을 관리하는데 내부에 stack 자료형 변수를 가짐으로 memento 객체를 저장하고 복원합니다. originator에게 메멘토 객체를 요청하고 일련의 명령을 수행합니다. 
memento는 originator의 state를 저장합니다. 외부에 state를 노출시키지 않고 originator에 의해서만 읽고 쓸 수 있습니다. 명령 이전의 상태로 되돌리기 위해 메멘토 객체를 originator에 반환합니다.

본 프로젝트에서는 환경 설정에서 폰트 사이즈를 바꾼 후에 되돌리기 버튼을 누르면 이전 상태로 돌아가는 기능을 구현하는데 사용하였습니다. 이 디자인 패턴을 사용한 이유는 기존에 폰트 사이즈나 화면 사이즈를 변경했을때 되돌아 가는 기능이 있다는 것을 생각했었고 이때 memento design pattern을 사용하면 효율적으로 적용할 수 있을것이라 생각했습니다. 


##### 8 - Visitor Design Pattern
Visitor design pattern이란 behavioral pattern으로써 데이터 구조와 연산을 분리하여 데이터 구조의 원소들을 변경하지 않고 새로운 연산을 추가 할 수 있는 디자인 패턴입니다. 새로운 연산을 추가하려면 새로운 방문자를 추가하기만 하면 됩니다.
오른쪽에는 Visitor와 VisitorImpl 이루어진 데이터 구조가 있습니다. 다만, 방문자를 수용하기 위해 Element 인터페이스를 상속받아서 accept() 메서드를 각각 구현하고 있으며 각 element의 경로를 구하는 연산 부분이 방문자에서 이루어집니다. 왼쪽에는 방문자로 데이터 구조를 방문하면서 필요한 연산을 수행합니다. 각 element에 접근하기 위한 visit메서드를 오버라이딩 및 오버로딩을 하고 있습니다

##### 9 - Command Design Pattern
Command Pattern이란 실행될 기능을 캡슐화함으로써 주어진 여러 기능을 실행할 수 있는, 재사용성이 높은 클래스를 설계하는 패턴입니다. 즉, 이벤트가 발생했을 때 실행될 기능이 다양하면서도 변경이 필요한 경우에 이벤트를 발생시키는 클래스를 변경하지 않고 재사용하고자 할 때 유용합니다. 실행될 기능을 캡슐화함으로써 기능의 실행을 요구하는 호출자(Invoker) 클래스와 실제 기능을 실행하는 수신자 (Receiver) 클래스 사이의 의존성을 제거합니다.

이번 Task Manager에서는 Task(업무), Schedule(스케쥴), Meeting(회의) 관리 세가지 기능을 주 기능으로 제공했지만 기능을 추가할 때 유용할 수 있다고 판단했습니다. Client의 역할은 Menu가 합니다. Menu는 Command 객체를 만들어, Invoker객체로 setCommand() 메소드를 통해 전달합니다. Command interface가 존재하고 Concrete Command로 TaskCommand, ScheduleCommand, MeetingCommand가 있습니다. Receiver는 TaskMenu, ScheduleMenu, MeetingMenu가 되어서 Command가 execute() 함으로써 각 Receiver들이 action 할 수 있습니다. action은 screen()이 됩니다.

