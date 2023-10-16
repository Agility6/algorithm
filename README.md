## Algorithms

### Introduce

- 🧮 Record the learning algorithms
- 📮 Document some commonly used algorithms

### 🦄 BASIC_ALGORITHMS

- [x] quick_sort
- [x] merge_sort
- [x] integer dichotomy
- [x] floating point dichotomy
- [x] one-dimensional prefixes sum

  ```tex
  S[i] = a[1] + a[2] + ... a[i]
  a[l] + ... + a[r] = S[r] - S[l - 1]
  ```
  
- [x] two-dimensional prefixes sum
  
  ```tex
  S[i, j] = 第i行j列格子左上部分所有元素的和
  以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵的和为：
  S[x2, y2] - S[x1 - 1, y2] - S[x2, y1 - 1] + S[x1 - 1, y1 - 1]
  ```

- [x] one-dimensional differential

    ```tex
    给区间[l, r]只每个数加上c: b[l] += c, b[r + 1] -= c
    满足以下规律
    a[i] = b[1] + b[2] + b[3] + ... + b[i]
    当b[l] += c 意味着求 a[l]的时候 --> a[l] = b[1] + b[2] + ... + b[l] + c
    那么 a[l + 1] = a[l] + b[l + 1] + c 也会+C 依次类推
    所以当我们 b[l] += c 执行这句时，后面的都会+c
    但是求的是[l, r]区域+c，所以将r+1后面的-c
    ```
- [x] two-dimensional differential

    ```tex
    给以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵中的所有元素加上c：

    总体思路和一位的差不多
    1. 先构造b数组
      b[x1, y1] += c
      b[x2 + 1, y1] -= c
      b[x1, y2 + 1] -= c
      [x2 + 1, y2 + 1] += c
    
    2. 对b数组求前缀和
      b[i][j] = b[x - 1][j] + b[x][j - 1] - b[i - 1][j - 1] + b[i][j]
    ```
- [ ] bit operations
- [x] double pointer algorithms
- [x] discretization
- [x] interval merging

### 🦄 BASIC_ALGORITHMS 

- [ ] Single Linked List
- [ ] Doubly Linked List 
- [ ] Stack
- [ ] Queue
- [ ] Monotone Stack
- [ ] Monotonic Queue
- [x] KMP

  ```java
  /** s[]是长文本，p[]是模式串，n是s的长度，m是p的长度 */

  /** 求模式串的Next数组 */
  for (int i = 2, j = 0; j <= m; i++) {

    while (j > 0 && p[i] != p[j + 1]) j = ne[j];

    if (p[i] == p[j + 1]) j++;

    ne[i] = j;
  }

  /** 匹配 */
  for (int i = 1, j = 0; i <= n; i++) {

    while (j > 0 && s[i] != p[j + 1]) j = ne[j];

    if (s[i] == p[j + 1]) j++;
    
    if (j == m) {
      j = ne[j];
      // 匹配成功
    }
  }
  ```

- [ ] Trie
- [ ] Disjoint-set data structure
- [ ] Heap
- [ ] Hash table
