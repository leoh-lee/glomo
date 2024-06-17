## 1. 도메인 분석
### 1) 경제뉴스 대시보드
- News API 호출
- 한글로 변환
- 주요 헤드라인을 가지고 AI로 5줄 요약
- 이미 읽었다면 다른 뉴스 가져오기
- 한국 뉴스인 지 판단 (한국뉴스라면 굳이 변환에 토큰 사용할 필요 X)

### 2) 실시간 주식 검색
- 계정별 관심종목조회 <span style='color:skyblue;'>WatchList</span>
- 종목 코드로 검색
- 종목 명으로 검색 <span style='color:skyblue;'>Asset (기본 데이터, 조회, 등록(배치), 수정, 삭제)</span>
- 계정별 최근 검색 저장
- 계정별 최근 검색 조회 <span style='color:skyblue;'>RecentSearch(유효기간, 검색어, 유저, 삭제, 등록)</span>
- 상품, 종목 관심 등록(계정별)
- 상품, 종목 정보 초기세팅
- 동적으로 매일 조회 -> 변경된 상황만 가져와서 업데이트
- 관심 종목 외에 기본적인 지수 출력 <span style='color:skyblue;'>BaseIndex(S&P500, 다우존스, 나스닥, 코스피, 코스닥, CPI, PPI, GDP 설장률, 실업률, 금리, 원/달러 환율, 국제유가)</span>
- 특정 시간 텀 기준으로 현재 지수로 시장상황 예측 -> 결과 캐싱하여 재사용 -> 모든 앱 공통 <span style='color:skyblue;'>Market Forecast(각종 지수, 지표와 예측 텍스트)</span>
- 종목별 게시판 <span style='color:skyblue;'>Board(종목 포함), Post(유저, Board)</span>

### 3) 포트폴리오 관리
- 종목과 금액 저장하는 전략 <span style='color:skyblue;'>Portfolio</span>
  - 종목, 금액 저장 및 수정
  - 총 금액 계산
  - 총 금액으로 % 환산
- 종목 모두 % 저장 전략
  - 투자금 입력 및 저장, 수정
  - 종목별 % 저장 및 계산 (100%를 넘을 수 없음)
  - 시장 예측 텍스트를 통해 포트폴리오 분석 (자동은 아니고 이벤트 발생 시) -> 캐싱필요, 분석 내용 저장
- 유저 <span style='color:skyblue;'>User</span>
  - 등록, 수정, 삭제
- 게시판 <span style='color:skyblue;'>Board</span>
  - 처음엔 없다가, 누군가 글 쓰면 해당 종목에 대한 Board 생성
- 게시글 <span style='color:skyblue;'>Post</span>
  - 좋아요, 싫어요
- 댓글 <span style='color:skyblue;'>Comment</span>
  - 좋아요, 싫어요