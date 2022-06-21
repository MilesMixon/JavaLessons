import { PropComponent } from './components/PropComponent';

const App = () => {
  return (
    <>
      <PropComponent name="Jimmy" age={12}>
        <p>
          This is my test text
        </p>
      </PropComponent>
    </>
  );
}

export default App