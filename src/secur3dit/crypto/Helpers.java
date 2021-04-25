package secur3dit.crypto;

/**
 * This class contains all the functions required to perform AES encryption.
 * Details at: https://en.wikipedia.org/wiki/Advanced_Encryption_Standard
 * @author  Priyanshul Govil
 */
final class Helpers {

    /**
     * This function performs the SubBytes step on a block of 16 bytes.
     * @param state     The state block of AES encryption.
     * @return Nothing  The value of state gets modified.
     */
    public static void subBytes(char[] state) {

        for (int i = 0; i < state.length; ++i) {
            state[i] = Constants.SBOX[state[i]];
        }
    }

    /**
     * This function performs the ShiftRows step on a block of 16 bytes.
     * @param state     The state block of AES encryption (char[16]).
     * @return Nothing  The value of state gets modified.
     */
    public static void shiftRows(char[] state) {

        // Row0 <<< 0

        // Row1 <<< 1
        char _temp = state[1];
        state[1] = state[5];
        state[5] = state[9];
        state[9] = state[13];
        state[13] = _temp;

        // Row2 <<< 2
        _temp = state[2];
        state[2] = state[10];
        state[10] = _temp;
        _temp = state[6];
        state[6] = state[14];
        state[14] = _temp;

        // Row3 <<< 3 - equivalent to Row3 >>> 1
        _temp = state[15];
        state[15] = state[11];
        state[11] = state[7];
        state[7] = state[3];
        state[3] = _temp;
    }
}
