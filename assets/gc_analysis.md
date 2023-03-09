<h1>Эксперименты с различными GC</h1>
<p>Тестируемая <a target="blank" href="https://github.com/plahotinandrei/job4j_design/src/main/java/ru/job4j/gc/prof">программа</a>.</p>
<p>Порядок действий при тестировании:</p>
<ol>
    <li>Cоздание массива 250000 элементов;</li>
    <li>Выполнить сортировку слиянием;</li>
    <li>Выполнить сортировку вставками;</li>
    <li>Выполнить сортировку пузырьком;</li>
    <li>Выход.</li>
</ol>
<h3>1. Parallel GC. Размер кучи 12 мб.</h3>
<p>Графики CPU и Heap выполнения сортировок слиянием, вставками и пузырьком соответственно:</p>
<figure>
    <img src="./images/parallel_cpu.jpg" alt="parallel_cpu">
    <figcaption>CPU</figcaption>
</figure>
<figure>
    <img src="./images/parallel_heap.jpg" alt="parallel_heap">
    <figcaption>Heap</figcaption>
</figure>
<p>Лог файл работы GC: <a target="blank" href="https://github.com/plahotinandrei/job4j_design/assets/files/parallel_log.txt">log.txt</a></p>
<p>Таймкоды сортировок:</p>
<ul>
    <li>
        MergeSort Начало сортировки - 20:57:18.70 <br/>
        MergeSort Конец сортировки - 20:57:18.90 <br/>
        MergeSort Время выполнения - 20ms
    </li>
    <li>
        InsertSort Начало сортировки - 20:58:06.01 <br/>
        InsertSort Конец сортировки - 20:58:11.44 <br/>
        InsertSort Время выполнения - 5s 43ms
    </li>
    <li>
        BubbleSort Начало сортировки - 20:58:54.92 <br/>
        BubbleSort Конец сортировки - 21:00:38.80 <br/>
        BubbleSort Время выполнения - 1m 43s 88ms
    </li>
</ul>
<p>Наблюдения:</p>
<p>График Heap похож на аналогичный график при использованиии Serial GC. На графики CPU земетны пики активности во время полной сборки.</p>
<h3>2. G1 GC. Размер кучи 12 мб.</h3>
<p>Графики CPU и Heap выполнения сортировок слиянием, вставками и пузырьком соответственно:</p>
<figure>
    <img src="./images/g1_cpu.jpg" alt="g1_cpu">
    <figcaption>CPU</figcaption>
</figure>
<figure>
    <img src="./images/g1_heap.jpg" alt="g1_heap">
    <figcaption>Heap</figcaption>
</figure>
<p>Лог файл работы GC: <a target="blank" href="https://github.com/plahotinandrei/job4j_design/assets/files/g1_log.txt">log.txt</a></p>
<p>Таймкоды сортировок:</p>
<ul>
    <li>
        MergeSort Начало сортировки - 21:00:51.52 <br/>
        MergeSort Конец сортировки - 21:00:51.74 <br/>
        MergeSort Время выполнения - 22ms
    </li>
    <li>
        InsertSort Начало сортировки - 21:01:02.09 <br/>
        InsertSort Конец сортировки - 21:01:07.53 <br/>
        InsertSort Время выполнения - 5s 44ms
    </li>
    <li>
        BubbleSort Начало сортировки - 21:01:23.91 <br/>
        BubbleSort Конец сортировки - 21:03:04.67 <br/>
        BubbleSort Время выполнения - 1m 40s 76ms
    </li>
</ul>
<p>Наблюдения:</p>
<p>
    Видим меньшие перепадов и более плавный график Heap с малым количеством явных пиков.
    Это связано с тем, что G1 избегает полных сборок. Но выполняет более частые смешанные сборки, которые очиищают молодое поколение, а также ряд регионов старого поколения, которые содержат больше всего мусора.
    А так же разбиением кучи на малые регионы, которые гибко распредиляются между Eden, Survivor и Old.
</p>
<h3>3. Z GC. Размер кучи 20 мб.</h3>
<p>Графики CPU и Heap выполнения сортировок слиянием, вставками и пузырьком соответственно:</p>
<figure>
    <img src="./images/zgc_cpu.jpg" alt="zgc_cpu">
    <figcaption>CPU</figcaption>
</figure>
<figure>
    <img src="./images/zgc_heap.jpg" alt="zgc_heap">
    <figcaption>Heap</figcaption>
</figure>
<p>Лог файл работы GC: <a target="blank" href="https://github.com/plahotinandrei/job4j_design/assets/files/zgc_log.txt">log.txt</a></p>
<p>Таймкоды сортировок:</p>
<ul>
    <li>
        MergeSort Начало сортировки - 21:17:38.59 <br/>
        MergeSort Конец сортировки - 21:17:38.75 <br/>
        MergeSort Время выполнения - 16ms
    </li>
    <li>
        InsertSort Начало сортировки - 21:17:46.29 <br/>
        InsertSort Конец сортировки - 21:17:51.71 <br/>
        InsertSort Время выполнения - 5s 42ms
    </li>
    <li>
        BubbleSort Начало сортировки - 21:18:02.20 <br/>
        BubbleSort Конец сортировки - 21:19:44.77 <br/>
        BubbleSort Время выполнения - 1m 42s 57ms
    </li>
</ul>
<p>Наблюдения:</p>
<p>
    Видим плавный график Heap с малым количеством явных пиков, но больший перепад по сравнению с другими GC.
    ZGC требует больше памяти для своей работы, чтобы обеспечить меньшую задержку и большую пропускную способность.
</p>