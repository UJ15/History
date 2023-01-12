## 핵심

- Comparator 를 잘 사용하는지 묻는 문제

## 내 접근

- head : number
- number : tail
- 두 개의 해시맵으로 정렬을 시도했었는데 코드가 너무 복잡해짐
- 핵심 코드
```java
Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = nameSplit(s1);
                String[] file2 = nameSplit(s2);

                int headDiff = file1[0].compareTo(file2[0]);

                if (headDiff == 0) {
                    return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
                }

                return headDiff;
            }
        });
```