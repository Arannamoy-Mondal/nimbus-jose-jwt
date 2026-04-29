The **RSA (Rivest-Shamir-Adleman) algorithm** is a foundational asymmetric cryptographic protocol heavily used in modern secure communications and network infrastructure. 

Unlike symmetric encryption where the same key is used for both locking and unlocking, RSA relies on a **key pair**: a public key to encrypt data and a private key to decrypt it. 

The mathematical security of RSA rests on the **integer factorization problem**. It is computationally trivial to multiply two large prime numbers together, but it is currently considered practically impossible for classical computers to reverse that process and discover the original primes from their product when the numbers are sufficiently large (e.g., 2048-bit integers).

### How the RSA Algorithm Works

The algorithm is broken down into three distinct phases: Key Generation, Encryption, and Decryption.

#### 1. Key Generation
The core of RSA relies on modular arithmetic and Euler's totient function.

*   **Step 1: Choose Primes.** Select two distinct prime numbers, $p$ and $q$. For security, these should be large and chosen at random.
*   **Step 2: Compute Modulus.** Calculate $n = p \times q$. The value $n$ is used as the modulus for both the public and private keys, and its length (usually expressed in bits) is the key length.
*   **Step 3: Compute Totient.** Calculate Euler's totient function, $\phi(n)$, which counts the positive integers up to $n$ that are relatively prime to $n$:
    $$\phi(n) = (p - 1) \times (q - 1)$$
*   **Step 4: Choose Public Exponent ($e$).** Select an integer $e$ such that $1 < e < \phi(n)$, and $e$ is **coprime** to $\phi(n)$. (This means their greatest common divisor is 1).
*   **Step 5: Compute Private Exponent ($d$).** Determine $d$ as the modular multiplicative inverse of $e$ modulo $\phi(n)$. Mathematically, this means finding a value for $d$ where:
    $$d \times e \equiv 1 \pmod{\phi(n)}$$

**The Keys:** 
*   **Public Key:** The pair $(n, e)$. This is shared openly.
*   **Private Key:** The pair $(n, d)$. This is kept strictly secret.

#### 2. Encryption
To encrypt a message, the sender must obtain the recipient's public key $(n, e)$. The plaintext message is converted into an integer $M$ (where $0 \le M < n$). The ciphertext $C$ is computed using modular exponentiation:
$$C \equiv M^e \pmod{n}$$

#### 3. Decryption
The recipient uses their private key $(n, d)$ to recover the original message $M$ from the ciphertext $C$:
$$M \equiv C^d \pmod{n}$$

---

### A Manual Example

Let's walk through a scaled-down example using small primes. 

1.  Let $p = 61$ and $q = 53$.
2.  Compute $n = 61 \times 53 = 3233$.
3.  Compute $\phi(n) = (61 - 1) \times (53 - 1) = 60 \times 52 = 3120$.
4.  Choose $e = 17$ (since 17 is a prime and doesn't divide 3120).
5.  Compute $d$. We need $d \times 17 \equiv 1 \pmod{3120}$. Using the Extended Euclidean algorithm, we find $d = 2753$ (because $17 \times 2753 = 46801$, which is $15 \times 3120 + 1$).

Our **Public Key** is $(3233, 17)$ and our **Private Key** is $(3233, 2753)$.

If we want to encrypt the message $M = 65$:
*   **Encrypt:** $C = 65^{17} \pmod{3233} = 2790$.
*   **Decrypt:** $M = 2790^{2753} \pmod{3233} = 65$.




**RSA (Rivest-Shamir-Adleman) অ্যালগরিদম** হলো আধুনিক সাইবার সিকিউরিটি এবং সুরক্ষিত যোগাযোগের একটি অন্যতম গুরুত্বপূর্ণ 'অ্যাসিমেট্রিক ক্রিপ্টোগ্রাফিক' (asymmetric cryptographic) প্রোটোকল।

সিমেট্রিক এনক্রিপশনে ডেটা লক এবং আনলক করতে একই চাবি (key) ব্যবহার করা হয়। কিন্তু RSA-তে **দুটি ভিন্ন চাবি বা কি-পেয়ার (key pair)** ব্যবহার করা হয়: একটি 'পাবলিক কি' (Public Key) যা দিয়ে ডেটা এনক্রিপ্ট বা লক করা হয়, এবং একটি 'প্রাইভেট কি' (Private Key) যা দিয়ে ডেটা ডিক্রিপ্ট বা আনলক করা হয়।

RSA এর নিরাপত্তা মূলত **মৌলিক উৎপাদকে বিশ্লেষণের (integer factorization problem)** গাণিতিক জটিলতার উপর নির্ভর করে। দুটি বড় মৌলিক সংখ্যাকে (prime numbers) গুণ করা খুব সহজ, কিন্তু গুণফল থেকে মূল সংখ্যা দুটি বের করা বর্তমানের সাধারণ কম্পিউটারগুলোর জন্য প্রায় অসম্ভব (বিশেষ করে যখন সংখ্যাগুলো অনেক বড় হয়, যেমন ২০৪৮-বিটের)।

### RSA অ্যালগরিদম কীভাবে কাজ করে

এই অ্যালগরিদমটি তিনটি প্রধান ধাপে বিভক্ত: কি জেনারেশন (Key Generation), এনক্রিপশন (Encryption) এবং ডিক্রিপশন (Decryption)।

#### ১. কি জেনারেশন (Key Generation)
*   **ধাপ ১: মৌলিক সংখ্যা নির্বাচন।** দুটি আলাদা মৌলিক সংখ্যা $p$ এবং $q$ বেছে নিন। নিরাপত্তার স্বার্থে এগুলো আকারে বড় ও র‍্যান্ডম হওয়া উচিত।
*   **ধাপ ২: মডুলাস (Modulus) হিসাব।** গুণফল বের করুন: $n = p \times q$। এই $n$ মানটি পাবলিক এবং প্রাইভেট উভয় কি-তেই ব্যবহৃত হয়।
*   **ধাপ ৩: টোশেন্ট (Totient) হিসাব।** অয়লারের টোশেন্ট ফাংশন $\phi(n)$ বের করুন:
    $$\phi(n) = (p - 1) \times (q - 1)$$
*   **ধাপ ৪: পাবলিক এক্সপোনেন্ট ($e$) নির্বাচন।** এমন একটি সংখ্যা $e$ বাছুন যেন $1 < e < \phi(n)$ হয় এবং $e$ সংখ্যাটি $\phi(n)$ এর সাথে সহমৌলিক (coprime) হয়। (অর্থাৎ এদের গসাগু বা GCD ১ হবে)।
*   **ধাপ ৫: প্রাইভেট এক্সপোনেন্ট ($d$) হিসাব।** $d$ এর মান এমন হতে হবে যেন এটি $e$ এর মডুলার মাল্টিপ্লিকেটিভ ইনভার্স (modulo $\phi(n)$) হয়। গাণিতিকভাবে:
    $$d \times e \equiv 1 \pmod{\phi(n)}$$

**কী-সমূহ (The Keys):** 
*   **পাবলিক কি (Public Key):** $(n, e)$। এটি সবার জন্য উন্মুক্ত থাকে।
*   **প্রাইভেট কি (Private Key):** $(n, d)$। এটি সম্পূর্ণ গোপন রাখতে হয়।

#### ২. এনক্রিপশন (Encryption)
কোনো মেসেজ পাঠাতে হলে, প্রেরক প্রাপকের পাবলিক কি $(n, e)$ ব্যবহার করেন। মেসেজটিকে প্রথমে একটি সংখ্যা $M$-এ রূপান্তর করা হয় (যেখানে $0 \le M < n$)। এরপর সাইফারটেক্সট বা গোপন সংকেত $C$ তৈরি করা হয় এভাবে:
$$C \equiv M^e \pmod{n}$$

#### ৩. ডিক্রিপশন (Decryption)
প্রাপক তার নিজের গোপন প্রাইভেট কি $(n, d)$ ব্যবহার করে সাইফারটেক্সট $C$ থেকে মূল মেসেজ $M$ উদ্ধার করেন:
$$M \equiv C^d \pmod{n}$$

---

### একটি সহজ উদাহরণ

ছোট মৌলিক সংখ্যা ব্যবহার করে একটি উদাহরণ দেখা যাক:

১. ধরি, $p = 61$ এবং $q = 53$।
২. $n$ হিসাব করি: $n = 61 \times 53 = 3233$।
৩. $\phi(n)$ হিসাব করি: $\phi(n) = (61 - 1) \times (53 - 1) = 60 \times 52 = 3120$।
৪. $e = 17$ বেছে নিই (কারণ ১৭ একটি মৌলিক সংখ্যা এবং ৩১২০ এর সাথে সহমৌলিক)।
৫. $d$ বের করি, যেখানে $d \times 17 \equiv 1 \pmod{3120}$। 'Extended Euclidean algorithm' ব্যবহার করে পাই, $d = 2753$ (কারণ $17 \times 2753 = 46801$, যা $15 \times 3120 + 1$)।

আমাদের **পাবলিক কি** হলো $(3233, 17)$ এবং **প্রাইভেট কি** হলো $(3233, 2753)$।

যদি আমরা একটি মেসেজ $M = 65$ এনক্রিপ্ট করতে চাই:
*   **এনক্রিপ্ট:** $C = 65^{17} \pmod{3233} = 2790$।
*   **ডিক্রিপ্ট:** $M = 2790^{2753} \pmod{3233} = 65$।


</GenerateWidget>