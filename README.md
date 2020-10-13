# :thumbsup: 서비스 소개

특정 기관, 회사, 사무실, 학교 등에서 자주 방문하는 방문자들의 음성을 등록하세요

OMO는 코로나를 예방하기 위해 마스크를 벗지 않고 음성만으로 방문자가 누구인지 판별해 자동으로 출입자 명부를 작성해줍니다

![image](https://user-images.githubusercontent.com/23401317/93544693-a9110980-f999-11ea-9fe2-64d0122e70a3.png)

<br>
<br>

<!--# 서비스 설계-->

<br>

## ✒ 와이어프레임 
[구경하러가기](https://www.figma.com/file/Ke6MIc0wdEYPm34qRRzKtI/%ED%8A%B9%ED%99%94-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-5%EB%B0%98-9%EC%A1%B0-%EC%99%80%EC%9D%B4%EC%96%B4%ED%94%84%EB%A0%88%EC%9E%84?node-id=0%3A1)

<br>
<br>

##  메인동작방식 (3가지 경우의 수)

Flow 1 ) 마스크인식 + 얼굴인식 한 큐에

: 캠에 인식 → `마스크디텍션 + 얼굴인식` → 결과값

Flow 2 ) 마스크인식 + 마스크 벗고 얼굴인식

: 캠에 인식 → `마스크디텍션` → 마스크 벗고 인식 요청 → `얼굴인식` → 결과값

 ✔ <strong> Flow 3 ) 마스크인식 + 음성인식으로 사람 식별 </strong>

: 캠에 인식 → `1. 마스크 디텍션` → 음성인식 요청 → `2. 음성인식` → 결과값

- 딥러닝 모델은 프론트에서 실행
- 마스크 디텍션 성공 시(결과값 : mask/no mask) 음성인식 페이지로
- 음성인식 5초 녹음 → 음성인식 모델 실행 → 결과값 반환
- 백엔드로 방문자 정보 전송 (사용자 관련 디비-MaridDB 는 미리 생성되어 있어야 함 → 이 부분 사용자가 음성 등록할때 사용자 정보랑 같이 저장하면 될 듯 → ? 사용자 음성파일이랑 분리해서 저장되니까 스키마 설계 얘기해봐야할 것)
- 백에서 방문시간 생성할 것 (방문로그는 NoSQL 로 파일형태 저장)
- 방문자 정보 성공적으로 저장되면 200 상태값 프론트로 전송

음성인식 5초

<br>
<br>
<br>

# 🖥 메인 화면

![main](https://user-images.githubusercontent.com/32058420/95405993-44bbe700-0954-11eb-8d27-fce5b01a793a.png)

<br>
<br>
<br>

# 😷 마스크 인식 -> 음성(화자) 인식 과정

![마스크-음성](https://user-images.githubusercontent.com/32058420/95840309-f311c300-0d7e-11eb-9822-722f88c870a5.png)


마스크가 인식이 되면 화자의 목소리를 통해 방문자가 눈군지 판별합니다

(음성 녹음 사용 컴포넌트 ```https://www.npmjs.com/package/vue-audio-recorder```)

<br>
<br>
<br>

# 👬 계정 관리
![image](https://user-images.githubusercontent.com/32058420/95406763-2c4ccc00-0956-11eb-99b0-4e60979d41e5.png)

<br>
<br>


- 등록 회원 관리 및 음성 훈련
 
<img src = 'https://user-images.githubusercontent.com/32058420/95609556-d6813c80-0a99-11eb-8f39-4b6b1ed9c24d.png' alt="회원관리" width=800px>

해당 기관에 등록 되어있는 회원들을 관리하고, 음성을 훈련 시킬 수 있습니다

<br>
<br>

- 방문자 명부

<img src = 'https://user-images.githubusercontent.com/32058420/95609715-22cc7c80-0a9a-11eb-9da4-ceac4ca0ae9d.png' alt="방문자명부" width=800px>

해당 기관에 방문한 사람들의 목록을 보여줍니다

<br>
<br>

- 음성 등록

<img src = 'https://user-images.githubusercontent.com/32058420/95406963-b8f78a00-0956-11eb-80c0-f0fd23ca2f83.png' alt="음성등록" width=450px>

기관에 새로 추가된 사람의 음성을 등록 할 수 있습니다

<br>
<br>
<br>

# 📃 프로젝트 정보

1.팀이름 : 찰떡꿀떡콩떡

2.프로젝트 이름 : omo ( only mask on your face)

3.주제 : 딥러닝을 활용한 방문자 명부 자동 입력 서비스

4.주요기능 : 마스크를 썼는지 인식, 방문자 인식

5.프론트 기술/담당 : 김강현, 배유진, 정용우

6.백앤드 기술/담당 : 배재원, 최문경

7.그 외 기술/담당 : 김강현 (배포), 정용우 (마스크 인식), 배유진 (음성 인식)

8.배포주소 : [http://j3a509.p.ssafy.io/](http://j3a509.p.ssafy.io/)


<br>
<br>
<br>

# :symbols: 사용한 기술
- **backend**
  - Spring
  - maria DB / JPA
- **frontend**
  - Vue.js
- **AI**
  - Tensorflow
  - keras
  - OpenCV
- **deploy**
  - AWS EC2
  - nginx
- **형상관리**
  - Jira
  - GitLab
  - 
  

## :calendar: 프로젝트 진행 일정

<img src="https://user-images.githubusercontent.com/32058420/95409680-227a9700-095d-11eb-8da0-9eb7eb19345d.png">
