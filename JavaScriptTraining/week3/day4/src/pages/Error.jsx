import { Center } from '../components/StylePractice';
import sadFace from '../Sad-Face-Emoji-480x480.png';

export const Error = () => {
    return (
        <Center>
            <h1>The page you were looking for could not be found.</h1>
            <div><img src={sadFace} alt="One sad boy" height={200}/></div>
        </Center>
    );
}