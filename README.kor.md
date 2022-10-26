# Grep 명령어

### 번역
[English](https://github.com/DavinAn6/GrepFilter/blob/main/README.md)

## 설명
grep 명령어는 지정한 특정 문자열을 검색하여 동일한 문자열이 있는 줄의 패턴을 찾아 화면에 출력합니다. Grep은 유닉스와 리눅스 모두에서 명령어와 옵션이 동일합니다. Grep은 **g**lobal search for **r**egular **e**xpression and **p**rint out의 약자입니다.
해당 프로그램에서는 자바언어를 이용하여 Grep을 구현합니다. Grep 명령어는 다양한 옵션이 존재하지만 해당 프로그램에서는 중 한가지만 적용합니다 : `-i, --ignore-case : 대소문자의 구별하지 않는다`

## 기능 요구사항
1. 프로그램은 Command Line 도구로 사용할 수 있다.
2. 프로그램은 Command Line에 입력된 값을 적절히 구분할 수 있다.
3. `-i` 옵션 사용 여부를 확인할 수 있다.
4. 지정된 파일 내에서 지정된 문자열을 찾을 수 있다.
5. 파일은 재귀적으로 검색한다.
6. 대소문자를 구분한 문자열과 구분하지 않은 문자열, 두가지 종류를 검색 할 수 있다.
7. 검색 결과는 다음과 같이 출력한며 각 출력값은 새 줄에 출력된다.  
   `[파일이름]:[줄번호]:[문자열이 포함된 줄]`
8. 예외 상황
    - IllegalArgumentException : 사용자가 필요한 명령어들을 입력하지 않은 경우
    - FileNotFoundException : 사용자가 존재하지 않는 파일명을 입력했을 경우
    - InvalidSearchStringException : 검색할 문자열에 줄 구분자가 있는 경우


## 사용방법
- 해당 프로그램은 Command Line을 통해 3가지 명령어를 받습니다.
  - 대소문자를 구별하지 않는 `-i` 옵션
  - 검색할 문자열
  - 검색할 파일명

### 예시
입력 :
```java Main -i "Never again" books```

출력 :
```
books\A\Austen\Emma.txt:12654:Bates should never again--no, never! If attention, in future, could do
books\A\Austen\PrideAndPrejudice.txt:10948:never again distressed himself, or provoked his dear sister Elizabeth,
books\A\LittleWomen.txt:10289:fever was a thing of the past.  Not an invalid exactly, but never again
books\B\Bronte\JaneEyre.txt:11518:"I will never again come to your side: I am torn away now, and cannot
books\B\Bronte\Villette.txt:1508:departure--little thinking then I was never again to visit it; never
books\B\Bronte\Villette.txt:13725:enlightened him, and taught him well never again to expect of me the
books\B\PeterPan.txt:3672:tree. As so often before, but never again.
books\B\PeterPan.txt:4487:personification of cockiness as, taken together, will never again, one
books\D\TheCountOfMonteCristo.txt:9269:with nothingness! Alone!—never again to see the face, never again to
books\D\TheCountOfMonteCristo.txt:14950:the poor fellow never again set foot in Tunis. This was a useless clause
books\D\TheCountOfMonteCristo.txt:24829:and the money stolen. Benedetto never again appeared at Rogliano,
books\D\TheCountOfMonteCristo.txt:53259:and she should never again see Morrel!
books\D\TheCountOfMonteCristo.txt:60437:Happily, I vanquished death. Henceforth, Valentine, you will never again
books\J\Ulysses.txt:17604:him aside as if he was so much filth and never again would she cast as
books\J\Ulysses.txt:32116:seaside but Id never again in this life get into a boat with him after
books\M\MobyDick.txt:9832:probability would be that he and his shipmates would never again
books\M\MobyDick.txt:19748:But in either case, the needle never again, of itself, recovers the
books\R\TheHistoryOfJava.txt:17344:his power) that he cursed them, and swore that they should never again
books\R\TheHistoryOfJava.txt:18427:Bumi_, that the earth might never again see to attack the heavens, and
books\S\Dracula.txt:2473:never again think that a man must be playful always, and never earnest,
```