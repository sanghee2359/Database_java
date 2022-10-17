import Parser.Parser;
import domain.Hospital;

public class HospitalParser implements Parser<Hospital> {   // Interface Parser의 구현체

    private String getSubdivision(String name) {
        String[] subDibisions = {"소아과", "피부과", "성형외과", "정형외과", "산부인과", "관절", "안과", "가정의학과", "비뇨기과", "치과", "내과", "외과"};
        for(String subDivision : subDibisions){
            if(name.contains(subDivision)) {
                return subDivision;
            }
        }
        return "";
    }

    public Hospital parse(String str) { // 참고로 첫번째 줄은 colum? 이라서 한 줄을 넘어가줘야한대요
        str= str.replaceAll("\"", "");
        String[] splitted = str.split(",");

        String name = splitted[10];
        String subDivision = getSubdivision(name);
        return new Hospital(splitted[0],splitted[1],splitted[2],splitted[6],name, subDivision);

    }
} //잠시 충전기 가지러,,,/
/*
1. interface parse
2. readLine 클래스에서 한줄씩 읽어오기
2. 구현체 hospitalparser 에서 한줄씩 읽어올 정보String을 split할 것입니다. -> 이때 parse 메소드에서 Hospital 객체를 return 즉 객체 생성함.
3. Hospital에서 id, address,,,등등을 초기화하여 특정 변수로 정의해준다?
4. hospital id까지 잘 구해졌으니, 다른 멤버변수를 구해볼 것입니다
5. subdivision 에러 끝내면 (현재 여기!)
6. sql insert문 메소드만들고
7. create 파일 하고 write하는것까지가 끝입니다.

*/
