class Q803_PseudorandomSequenceTest {

//    @Test
    fun testTranslate() {
        assert(Q803_PseudorandomSequence.translate(0) == 'a')
        assert(Q803_PseudorandomSequence.translate(1) == 'b')
        assert(Q803_PseudorandomSequence.translate(25) == 'z')
        assert(Q803_PseudorandomSequence.translate(26) == 'A')
        assert(Q803_PseudorandomSequence.translate(27) == 'B')
        assert(Q803_PseudorandomSequence.translate(51) == 'Z')
    }

}
