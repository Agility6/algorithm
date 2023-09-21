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
  给以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵中的所有元素加上c：
  S[x1, y1] += c, S[x2 + 1, y1] -= c, S[x1, y2 + 1] -= c, S[x2 + 1, y2 + 1] += c
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
- [ ] two-dimensional differential
- [ ] bit operations
- [x] double pointer algorithms
- [ ] discretization
- [ ] interval merging
