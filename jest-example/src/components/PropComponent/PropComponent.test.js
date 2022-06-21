import renderer from 'react-test-renderer';
import PropComponent from './PropComponent';

//snapshot testing
//allows us to take a snapshot of a component and test against
it('renders properly', () => {
    //can tell the renderer what component/ componenets we want it to create
    //when we first run it, it wil lautomatically make a snapshot of this
    const component = renderer.create(
        <PropComponent name="TestName" age={21}>
            <p>Test Text</p>
        </PropComponent>
    );

    const tree = component.toJSON();
    expect(tree).toMatchSnapshot();
});

//run tests with npm test. check the README for more info on commands
//runs in "watch mode", so everytime you save while in that mode it just reruns your tests