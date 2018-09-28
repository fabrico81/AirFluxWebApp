'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {flights: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/flights'}).done(response => {
			this.setState({flights: response.entity._embedded.flights});
		});
	}

	render() {
		return (
			<FlightsList flights={this.state.flights}/>
		)
	}
}
// end::app[]

// tag::flight-list[]
class FlightsList extends React.Component{
	render() {
		const flights = this.props.flights.map(flight =>
			<Flight key={flight._links.self.href} flight={flight}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Departure</th>
						<th>Destination</th>
						<th>Time</th>
					</tr>
					{flights}
				</tbody>
			</table>
		)
	}
}
// end::flight-list[]

// tag::flight[]
class Flight extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.flight.origin} </td>
				<td>{this.props.flight.destination}</td>
				<td>{this.props.flight.departure}</td>
			</tr>
		)
	}
}
// end::flight[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

