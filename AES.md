**Cryptography** is simply the art of protecting information by turning a normal, readable message (called plaintext) into a scrambled, secret code (called ciphertext).

**AES (Advanced Encryption Standard)** is a highly secure, globally accepted method used to create these secret codes to protect sensitive data. It was adopted by the US government because the older standard, called DES, became too weak and could be hacked by computers in just 50 hours. In 2001, an algorithm named "Rijndael" won a competition to become the new AES standard because it was highly secure, cost-effective, and easy to implement.

Here is an easy breakdown of **how AES works**:

AES scrambles data in blocks of 128 bits using a secret **key** (which you can think of as a really strong password). The algorithm runs the data through a series of repeating cycles called **"rounds"**. The larger your secret key, the more rounds the data goes through, making it more secure (but slightly slower for the computer to process):
*   128-bit keys go through **10 rounds**.
*   192-bit keys go through **12 rounds**.
*   256-bit keys go through **14 rounds**.

During each of these rounds, AES scrambles the data using **four main steps**:
1. **Sub Bytes (Substitute Bytes):** Every piece of the data is swapped out for a completely different piece of data using a complex lookup table called an "S-box". 
2. **Shift Rows:** The data is organized into rows, and those rows are shifted to the left by different amounts (for example, the first row doesn't move, the second row shifts by one spot, the third by two spots). 
3. **Mix Columns:** This is the most important step for scrambling. It mathematically mixes the columns of data together, causing the changes to spread completely over the block so the original message is unrecognizable. *(Note: This step is skipped in the very last round)*
4. **Add Round Key:** A piece of your secret key is mathematically combined with the scrambled data. Because using the exact same key over and over would weaken the security, the system "expands" your main password into several unique "round keys" so a fresh one is used in every single round.

**Can it be hacked?** 
Practically, no. Trying to break AES by using an exhaustive key search (which means using a computer to guess every single possible password combination) is considered completely infeasible with our current technology for 128-bit keys and above. Even advanced hacking methods aimed at AES-256 are currently unable to break it.



**ক্রিপ্টোগ্রাফি কী? (What is Cryptography?)**
ক্রিপ্টোগ্রাফি হলো তথ্য সুরক্ষিত রাখার একটি কৌশল, যেখানে মূল মেসেজ বা বার্তাকে (যাকে 'প্লেইনটেক্সট' বলা হয়) পরিবর্তন করে একটি এনকোড করা মেসেজে রূপান্তর করা হয় (যাকে 'সাইফার' বা 'সাইফারটেক্সট' বলা হয়)। 

**AES কী? (What is AES?)**
* অ্যাডভান্সড এনক্রিপশন স্ট্যান্ডার্ড (AES) হলো একটি এনক্রিপশন মানদণ্ড যা আমেরিকার ন্যাশনাল ইনস্টিটিউট অফ স্ট্যান্ডার্ডস অ্যান্ড টেকনোলজি (NIST) দ্বারা গোপনীয় তথ্য সুরক্ষিত করার জন্য বেছে নেওয়া হয়েছে। সংবেদনশীল ডেটা এনক্রিপ্ট করার জন্য একটি নির্ভরযোগ্য অ্যালগরিদম হিসেবে এটি বিশ্বব্যাপী ব্যাপকভাবে গৃহীত হয়েছে।
* এটি একটি 'ব্লক সাইফার' যা ডেটা এনক্রিপ্ট এবং ডিক্রিপ্ট উভয়ের জন্য ১২৮-বিট সাইজের ব্লকের ওপর কাজ করে। 
* এর প্রতিটি রাউন্ডে একই ধরনের অপারেশন বা কাজ সম্পন্ন হয়।

**কেন AES ব্যবহার করা হয়? (Why AES?)**
* ১৯৯০-এর দশকে পূর্ববর্তী DES অ্যালগরিদম ক্র্যাক করা বা ভাঙা সম্ভব হয়েছিল (প্রায় ৫০ ঘণ্টার ব্রুটফোর্সিং ব্যবহার করে মূল মেসেজটি উদ্ধার করা সম্ভব হয়)। 
* তাই NIST নতুন ও কার্যকর অ্যালগরিদম খোঁজা শুরু করে এবং ১৯৯৭ সালে এর প্রয়োজনীয়তা ও শর্তাবলি প্রস্তাব করে। 
* ২০০১ সালে বেলজিয়ামের দুই বিজ্ঞানী রিজমেন্ট (Rijment) এবং ডেমন (Daemon)-এর ডিজাইন করা 'Rijndael' অ্যালগরিদমটি প্রতিযোগিতায় বিজয়ী হিসেবে ঘোষিত হয়। এটি নিরাপত্তা, খরচ এবং বাস্তবায়নের সকল মাপকাঠি সাফল্যের সাথে পূরণ করেছিল।

**এটি কীভাবে কাজ করে? (How Does it work?)**
AES ডেটা এনক্রিপ্ট করার জন্য মূলত ৪টি প্রধান ফাংশন বারবার পুনরাবৃত্তি করে: ১. সাব বাইটস (Sub Bytes), ২. শিফট রোস (Shift Rows), ৩. মিক্স কলামস (Mix Columns), এবং ৪. অ্যাড কি (Add Key)। এটি ১২৮ বিটের ডেটা ব্লক এবং একটি 'কি' (সাধারণ মানুষের ভাষায় যাকে পাসওয়ার্ড বলা যায়) ইনপুট হিসেবে নেয় এবং আউটপুট হিসেবে একটি সাইফারটেক্সট বা গুপ্ত সংকেত প্রদান করে। 

অ্যালগরিদমের রাউন্ড সংখ্যা সরাসরি 'কি'-এর সাইজের ওপর নির্ভর করে:
* ১২৮ বিট কি-এর জন্য: ১০ রাউন্ড
* ১৯২ বিট কি-এর জন্য: ১২ রাউন্ড
* ২৫৬ বিট কি-এর জন্য: ১৪ রাউন্ড
'কি'-এর সাইজ যত বড় হবে, ডেটা তত বেশি সুরক্ষিত থাকবে, তবে রাউন্ড সংখ্যা বাড়ার কারণে ডেটা এনক্রিপ্ট করতে সফটওয়্যারের বেশি সময় লাগবে।

**ধাপসমূহের বিশ্লেষণ (Analysis of Steps):**
* **কি এক্সপ্যানশন (Key Expansions):** এই প্রক্রিয়ায় প্রদত্ত ১২৮ বিটের সাইফার কি-কে একটি [৪]x[৪] বাইট ম্যাট্রিক্সে জমা রাখা হয় এবং এরপর একে প্রসারিত করে ৪৪টি ওয়ার্ডের একটি শিডিউল তৈরি করা হয়, যার ফলে ১১টি রাউন্ড কি (Round keys) পাওয়া যায়।
* **সাব বাইটস (Sub Bytes):** ম্যাট্রিক্সের প্রতিটি উপাদানকে S-box ম্যাট্রিক্সের একটি উপাদান দ্বারা প্রতিস্থাপন করা হয়। S-box হলো গ্যালয়েস ফিল্ড (Galois fields) দ্বারা তৈরি একটি বিশেষ লুকআপ টেবিল, যেখানে ২৫৬টি মান থাকা সম্ভব।
* **শিফট রোস (Shift Rows):** এই ধাপে ডেটা ব্লকের সারিগুলোকে বাম দিকে চক্রাকারে (cylindrically) শিফট করা হয়। ম্যাট্রিক্সের প্রথম সারিটি অপরিবর্তিত থাকে, দ্বিতীয় সারি ১ ঘর, তৃতীয় সারি ২ ঘর এবং চতুর্থ সারি ৩ ঘর শিফট হয়। 
* **মিক্স কলামস (Mix Columns):** এটি অ্যালগরিদমের সবচেয়ে গুরুত্বপূর্ণ অংশ, যা বিটগুলোকে পুরো ব্লকে ছড়িয়ে দেয়। এখানে ব্লককে একটি নির্দিষ্ট ম্যাট্রিক্সের সাথে গ্যালয়েস ফিল্ড মাল্টিপ্লিকেশন প্রক্রিয়ায় গুণ করা হয়। তবে, এনক্রিপশনের একেবারে শেষ রাউন্ডে এই 'মিক্স কলাম' ধাপটি বাদ দেওয়া হয়।
* **অ্যাড রাউন্ড কি (Add round key):** এই ধাপে ডেটার প্রতিটি বাইট কি-ম্যাট্রিক্সের সংশ্লিষ্ট উপাদানের সাথে XOR করা হয়। একবার এই কাজ সম্পন্ন হলে একই কি পুনরায় ব্যবহার করলে অ্যালগরিদম দুর্বল হয়ে যেতে পারে, তাই এই সমস্যা এড়াতে 'কি' গুলোকে এক্সপ্যান্ড বা প্রসারিত করা হয়।

**অ্যাটাক বা আক্রমণ (Attacks):**
AES-এর ওপর আক্রমণ করার পদ্ধতি এক্সহস্টিভ কি-সার্চ অ্যাটাকের (Exhaustive key search attack বা সম্ভাব্য সব পাসওয়ার্ড চেষ্টা করা) মতোই, তবে এটি আগের চেয়ে ৪ গুণ বেশি উন্নত। তা সত্ত্বেও, বর্তমান প্রযুক্তি ব্যবহার করে ১২৮ বিট বা তার বেশি কি-স্পেসের ব্লক সাইফার ভাঙা প্রায় অসম্ভব (infeasible)। AES-২৫৬ বিটের ওপর 'রিলেটেড কি-অ্যাটাক' (Related Key Attack) নামক আরও উন্নত আক্রমণ পদ্ধতি থাকলেও বর্তমান প্রেক্ষাপটে সেগুলোও সফল হওয়া প্রায় অসম্ভব।

